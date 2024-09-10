import React, { useContext } from "react";
import logo from "../../assets/images/logo.png";
import SearchIcon from "@mui/icons-material/Search";
import {
  Box,
  Button,
  Grid,
  Stack,
  TextField,
  Typography,
} from "@mui/material";
import { css } from "@emotion/css";
import Carousel from "react-bootstrap/Carousel";
import { useTheme } from "@mui/material/styles";
import { Container, Image, Nav, NavDropdown, Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";
import { MyDispatchContext, MyUserContext } from "../../configs/Contexts";

const Header = () => {
  const theme = useTheme();
  const breakpoints = Object.values(theme.breakpoints.values);
  const mq = breakpoints.map((bp) => `@media (min-width: ${bp}px)`);
  const user = useContext(MyUserContext);
  const dispatch = useContext(MyDispatchContext);
  return (
    <Box
      component="header"
      className={css`
        background: #1150a0;
        padding: 20px 0;
      `}
    >
      <Box
        component="header"
        className={css`
          background: #1150a0;
          padding: 20px 0;
        `}
      ></Box>
      <Box
        component="section"
        className={css`
          margin: 0 auto;
          width: 90%;
          ${mq[3]} {
            width: 70%;
          }
          ${mq[4]} {
            width: 70%;
          }
        `}
      >
        <Grid
          container
          direction="row"
          justifyContent="space-between"
          alignItems="center"
          spacing={2}
        >
          <Grid item xs={12} md={6}>
            <Box
              display="flex"
              alignItems="center"
              color="#fff"
              className={css`
                text-align: left;
                gap: 5px;
                justify-content: center;
              `}
            >
              <img
                src={logo}
                alt="logo"
                className={css`
                  display: block;
                `}
              />
              <Typography
                variant="h6"
                className={css`
                  font-size: 16px !important;
                  ${mq[1]} {
                    font-size: 18px !important;
                  }
                `}
              >
                Cổng thông tin tuyển sinh
                <br />
                Trường Đại học Mở Thành phố Hồ Chí Minh
              </Typography>
            </Box>
          </Grid>
          <Grid
            item
            xs={12}
            md={6}
            className={css`
              display: flex;
              justify-content: center;
              ${mq[1]} {
                justify-content: flex-end;
              }
            `}
          >
            <TextField
              id="outlined-basic"
              defaultValue="Tìm kiếm"
              variant="outlined"
              className={css`
                font-size: 14px;
                background: #fff;
                border: 1px solid #000;
                .MuiInputBase-input {
                  padding: 7px !important;
                }
              `}
            />
            <Button
              variant="contained"
              className={css`
                margin-left: 8px;
              `}
            >
              <Stack direction="row" spacing={1}>
                <SearchIcon />
                <Typography variant="span">Tìm&nbsp;kiếm</Typography>
              </Stack>
            </Button>
          </Grid>
          <Grid item xs={12}>
            <Navbar expand="lg" className="bg-body-tertiary">
              <Container>
                <Navbar.Collapse id="basic-navbar-nav">
                  <Nav className="me-auto">
                    <Link to="/" className="nav-link">
                      TRANG CHỦ
                    </Link>
                    <NavDropdown
                      title="THÔNG TIN TUYỂN SINH"
                      id="TTTS"
                    ></NavDropdown>
                    <Nav.Link href="#">THÔNG TIN KHOA-NGÀNH</Nav.Link>
                    <NavDropdown title="THÔNG TIN THAM KHẢO" id="TTTK">
                      <NavDropdown.Item href="#action/3.1">
                        {" "}
                        Điểm chuẩn các năm{" "}
                      </NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.2">
                        Tỉ lệ có việc làm
                      </NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.3">
                        Học bổng tuyển sinh
                      </NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.4">
                        Học phí năm học 2024 - 2025
                      </NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.5">
                        Các văn bản pháp lý
                      </NavDropdown.Item>
                    </NavDropdown>
                    {user === null ? (
                      <>
                        <Link to="/login" className="nav-link">
                          ĐĂNG NHẬP
                        </Link>
                        <Link to="/register" className="nav-link">
                          ĐĂNG KÝ
                        </Link>
                      </>
                    ) : (
                      <>
                        <Link to="/" className="nav-link">
                          <Image src={user.avatar} width="40" roundedCircle />{" "}
                          {user.username}
                        </Link>
                        <Link onClick={() => dispatch({"type": "logout"})} className="nav-link">
                          ĐĂNG XUẤT
                        </Link>
                      </>
                    )}
                  </Nav>
                </Navbar.Collapse>
              </Container>
            </Navbar>
            <Carousel>
              <Carousel.Item interval={1000}>
                <img
                  src="https://tuyensinh.ou.edu.vn/tmp/rscache/1110x475-7310001-2024v1-01.png"
                  alt="First slide"
                  className={css`
                    width: 100%;
                  `}
                />
              </Carousel.Item>
              <Carousel.Item interval={500}>
                <img
                  src="https://tuyensinh.ou.edu.vn/tmp/rscache/1110x475-New%20year%202024-v1_Mesa%20de%20trabajo%201.png"
                  alt="Second slide"
                  className={css`
                    width: 100%;
                  `}
                />
              </Carousel.Item>
              <Carousel.Item>
                <img
                  src="https://tuyensinh.ou.edu.vn/tmp/rscache/1110x475-New%20year%202024-v1_Mesa%20de%20trabajo%201.png"
                  alt="Third slide"
                  className={css`
                    width: 100%;
                  `}
                />
              </Carousel.Item>
            </Carousel>
          </Grid>
        </Grid>
      </Box>
    </Box>
  );
};

export default Header;