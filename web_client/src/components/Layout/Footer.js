import {Box, Grid, Typography} from "@mui/material";
import React, {Fragment} from "react";
import {css} from "@emotion/css";
import LocationOnIcon from '@mui/icons-material/LocationOn';
import EmailIcon from '@mui/icons-material/Email';
import LocalPhoneIcon from '@mui/icons-material/LocalPhone';
import BusinessIcon from '@mui/icons-material/Business';
import {useTheme} from "@mui/material/styles";
const Footer = () => {
    const theme = useTheme()
    const breakpoints = Object.values(theme.breakpoints.values)
    console.log(breakpoints)
    const mq = breakpoints.map(bp => `@media (min-width: ${bp}px)`)
    return (
        <>
            <Box component="footer" className={css`
                margin-top:16px;
                
            `}>
                <Box component="section" className={css`padding:8px 0;background:#E8EBF4 !important`}>
                    <Box component="section" className={css`
                        margin-left:auto;
                        margin-right: auto;
                        width:100%;
                        padding: 2.5vh;
                        ${mq[3]} {
                            width:70%;
                            padding:0
                        }
                        ${mq[4]} {
                            width:50%;
                            padding:0
                        }
                    
                    `}>
                        <Grid container spacing={5}
                              justifyContent="space-around"
                              alignItems="flex-start"
                              className={css`
                            margin-top: 16px!important;
                        `}>
                            <Grid className={css`text-align: left`} xs={12} md={4}>
                                <Typography className=
                                                {css`
                                                    margin-bottom: 24px !important;
                                                    text-align: left;`} variant="h5">
                                    Ho Chi Minh City
                                    <br/>
                                    OPEN UNIVERSITY
                                </Typography>

                                <section className={css`display: flex;
                                    gap: 16px`}>
                                    <LocationOnIcon/>
                                    <Typography className={css`color: #000;font-size:14px`} variant="span">35-37 Hồ Hảo Hớn, P.Cô Giang,
                                        Q1, Tp.HCM </Typography>
                                </section>
                                <section className={css`display: flex;
                                    gap: 16px`}>
                                    <LocalPhoneIcon/>
                                    <Typography className={css`color: #000;font-size:14px`} variant="span">028.39207627;
                                        08.39300072 </Typography>
                                </section>
                                <section className={css`display: flex;
                                    gap: 16px`}>
                                    <BusinessIcon/>
                                    <Typography className={css`color: #000;font-size:14px`} variant="span">tuyensinh@ou.edu.vn</Typography>
                                </section>
                                <section className={css`display: flex;
                                    gap: 16px`}>
                                    <EmailIcon/>
                                    <Typography className={css`color: #000;font-size:14px`} variant="span">tuyensinh@ou.edu.vn</Typography>
                                </section>
                            </Grid>
                            <Grid className={css`text-align: left`} xs={12} md={4}>
                                <Typography className=
                                                {css`
                                                    margin-bottom: 24px !important;
                                                    text-align: left;`} variant="h5">
                                    CƠ SỞ TRỰC THUỘC
                                </Typography>
                                <section className={css`display: flex;
                                `}>
                                    <Typography className={css`color: #000;font-size:14px`} variant="span">Cơ sở 1: 97 Võ Văn Tần P6 Q3
                                        Tp.HCM </Typography>
                                </section>

                                <section className={css`display: flex;
                                    gap: 14px`}>
                                    <Typography className={css`color: #000;font-size:14px`} variant="span">Cơ sở 2: 35-37 Hồ Hảo Hớn,
                                        Phường Cô Giang, Quận 1, Tp. Hồ Chí Minh.</Typography>
                                </section>
                                <section className={css`display: flex;
                                    gap: 14px`}>
                                    <Typography className={css`color: #000;font-size:14px`} variant="span">Cơ sở 3: Khu Dân cư Nhơn Đức,
                                        Huyện Nhà Bè, Thành phố Hồ Chí Minh.</Typography>
                                </section>
                                <section className={css`display: flex;
                                    gap: 14px`}>
                                    <Typography className={css`color: #000;font-size:14px`} variant="span">Cơ sở 4: 02 Mai Thị Lựu, Phường
                                        Đa Kao, Quận 1, Tp. Hồ Chí Minh.</Typography>
                                </section>
                                <section className={css`display: flex;
                                    gap: 14px`}>
                                    <Typography className={css`color: #000;font-size:14px`} variant="span">Cơ sở 5: 68 Lê Thị Trung, Tp.Thủ
                                        Dầu Một, Tỉnh Bình Dương.
                                    </Typography>
                                </section>
                                <section className={css`display: flex;
                                    gap: 14px`}>
                                    <Typography className={css`color: #000;font-size:14px`} variant="span">Cơ sở 6: Phường Long Bình Tân,
                                        Tp. Biên Hòa, Tỉnh Đồng Nai.</Typography>
                                </section>
                            </Grid>
                            <Grid xs={12} md={4}>
                                <section>
                                    <iframe
                                        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d952.0180457814291!2d106.69235475239498!3d10.760893968458824!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752f114014707f%3A0x3f198b980ca59fdf!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBN4bufIFRQLkhDTSAtIEPGoSBz4bufIDI!5e0!3m2!1svi!2s!4v1715273906836!5m2!1svi!2s"
                                        width="400" height="300" allowFullScreen="" loading="lazy"
                                        referrerPolicy="no-referrer-when-downgrade"></iframe>
                                </section>
                            </Grid>
                        </Grid>
                    </Box>
                </Box>

                <Box component="section" className={css`padding:8px;background:#1150A0 !important;color:rgba(255,255,255,.6)!important;`}>
                    <Typography variant="span">
                        42275494<br/>
                        © 2020 .<br/>
                        Thiết kế và phát triển bởi Trung tâm Quản lý Hệ thống Thông tin.
                    </Typography>
                </Box>
            </Box>
        </>
    );
}

export default Footer;