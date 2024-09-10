import React, { useEffect, useState } from "react";
import MySpinner from "../Layout/MySpinner";
import API, { endpoints } from "../../configs/API";
import { Link} from "react-router-dom";
import { Button } from "react-bootstrap";
import Moment from "react-moment";
const Home = () => {
    const [news, setNews ] = useState(null);
     const [page, setPage] = useState(1);
     const [loading, setLoading] = useState(false);

    const loadNews = async () => {
        let url = `${endpoints["news"]}?page=${page}`;
        const res = await API.get(url);
        setNews(res.data);

        if (page === 1)
          setNews(res.data);
        else 
          setNews(current => {
          return [...current, ...res.data];
    })
  }

    useEffect(() => {
      loadNews();
    }, [page]);

    const loadMore = () => {
      if (!loading) setPage(page + 1);
    };
  
    if (news===null)
      return <MySpinner />;

    return (
      <>
        <h3 className="ms-3">THÔNG TIN TUYỂN SINH ĐẠI HỌC CHÍNH QUY</h3>
        {news.map((n) => {
          let url = `/news/${n.id}`;
          return (
            <div key={n.id} className="news-item">
              <Link to={url}>
                <h5> {n.tieuDe}</h5>
              </Link>{" "}
              {/* <Moment locale="vi" fromNow>
                {n.createdDate}
              </Moment> */}
              <hr />
            </div>
          );
        })}
        {loading && page > 1 && <MySpinner />}
        <div className="text-center">
          <Button variant="info" onClick={loadMore} disabled={loading}>
            Xem thêm
          </Button>
        </div>
      </>
    );
};

export default Home;
