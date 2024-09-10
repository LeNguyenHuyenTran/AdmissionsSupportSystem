import { Alert, Button, Container, Form } from "react-bootstrap";
import API, { endpoints } from "../../configs/API";
import { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import MySpinner from "../Layout/MySpinner";

const Register = () => {
  const fields = [
    {
      label: "Tên người dùng",
      type: "text",
      field: "fullName",
    },
    {
      label: "Email",
      type: "email",
      field: "email",
    },
    {
      label: "Tên đăng nhập",
      type: "text",
      field: "username",
    },
    {
      label: "Mật khẩu",
      type: "password",
      field: "password",
    },
    {
      label: "Xác nhận mật khẩu",
      type: "password",
      field: "confirmPassword",
    },
  ];

  const [loading, setLoading] = useState(false);
  const [err, setErr] = useState(null);
  const [user, setUser] = useState({});
  const avatar = useRef(); /*sd useRef de link vo dom that*/
  const nav = useNavigate();

  const change = (e, field) => {
    setUser((current) => {
      return { ...current, [field]: e.target.value };  /*array destructory*/
    });
  };

  const register = async (e) => {
    e.preventDefault();

    let form = new FormData();
    for (let key in user) if (key !== "confirmPassword") form.append(key, user[key]);

    if (avatar) form.append("file", avatar.current.files[0]);
    
    try {
      let res = await API.post(endpoints["register"], form, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });
      if (res.status === 201) nav("/login");
    } catch (ex) {
      console.error(ex);
    }
  };
 

  return (
    <Container>
      <h1 className="text-center text-info mt-1">ĐĂNG KÝ NGƯỜI DÙNG</h1>
      {/* {err === null ? "" : <Alert variant="danger">{err}</Alert>} */}
      <Form onSubmit={register}>
        {fields.map((f) => (
          <Form.Group key={f.field} className="mb-3" controlId={f.field}>
            <Form.Label>{f.label}</Form.Label>
            <Form.Control
              onChange={(e) => change(e, f.field)}
              value={user[f.field]}
              type={f.type}
              placeholder={f.label}
            />
          </Form.Group>
        ))}

        <Form.Group className="mb-3" controlId="avatar">
          <Form.Label>Ảnh đại diện</Form.Label>
          <Form.Control type="file" accept=".png,.jpg" ref={avatar} />
        </Form.Group>
        <Form.Group className="mb-3">
            <Button type="submit" variant="danger">
              Đăng ký
            </Button>
        </Form.Group>
      </Form>
    </Container>
  );
}

export default Register;
