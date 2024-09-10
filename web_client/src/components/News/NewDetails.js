import { useContext, useEffect, useState } from "react";
import { Button, Col, Form, Image, ListGroup, Row } from "react-bootstrap";
import Moment from "react-moment";
import { Link, useParams } from "react-router-dom";
import { MyUserContext } from "../../configs/Contexts";
import API, { authApi, endpoints } from "../../configs/API";
import MySpinner from "../Layout/MySpinner";

const NewDetails = () => {
  const [user] = useContext(MyUserContext);
  const { newId } = useParams(); // {} lấy thuộc tính của đối tượng chứ không lấy nguyên đối tượng (destructory)
  const [new1, setNew] = useState(null);
  const [comments, setComments] = useState(null);
  const [binhLuan, setbinhLuan] = useState();

  useEffect(() => {
    const loadNew = async () => {
      let { data } = await API.get(endpoints["newdetails"](newId));
      setNew(data);
    };

    const loadComments = async () => {
      let { data } = await API.get(endpoints["comments"](newId));
      setComments(data);
    };

    loadNew();
    loadComments();
  }, []);

  const addComment = () => {
    const process = async () => {
      let { data } = await authApi().post(endpoints["add-comment"], {
        binhLuan: binhLuan,
        new1: new1.id,
      });

      setComments([...comments, data]);
    };

    process();
  };

  if (new1 === null || comments === null) return <MySpinner />;

  let url = `/login?next=/news/${newId}`;
  return (
    <>
      <h1 className="text-center text-info mt-2">
        CHI TIẾT ({newId})
      </h1>
      <h2>{new1.tieuDe}</h2>
      <p>{new1.thongTin.noiDung}</p>
      <hr />

      {user === null ? (
        <p>
          Vui lòng <Link to={url}>đăng nhập</Link> để bình luận!{" "}
        </p>
      ) : (
        <>
          <Form.Control
            as="textarea"
            aria-label="With textarea"
            value={binhLuan}
            onChange={(e) => setbinhLuan(e.target.value)}
            placeholder="Nội dung bình luận"
          />
          <Button onClick={addComment} className="mt-2" variant="info">
            Bình luận
          </Button>
        </>
      )}
      <hr />
      <ListGroup>
        {comments.map((c) => (
          <ListGroup.Item id={c.id}>
            {c.userId.username} - {c.binhLuan} -{" "}
            <Moment locale="vi" fromNow>
              {c.createdDate}
            </Moment>
          </ListGroup.Item>
        ))}
      </ListGroup>
    </>
  );
};

export default NewDetails;
