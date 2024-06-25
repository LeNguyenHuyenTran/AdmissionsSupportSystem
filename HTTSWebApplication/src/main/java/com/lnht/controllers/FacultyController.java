/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.AdmissionScoreDTO;
import com.lnht.pojo.Chuongtrinhdaotao;
import com.lnht.pojo.Diemtrungtuyen;
import com.lnht.pojo.EducationProgramDTO;
import com.lnht.pojo.FacultyDTO;
import com.lnht.pojo.Khoa;
import com.lnht.pojo.MajorDTO;
import com.lnht.pojo.Nganh;
import com.lnht.pojo.Tintuyensinh;
import com.lnht.service.AdmissionNewsService;
import com.lnht.service.FacultyService;
import com.lnht.service.TypeOfAdmissionService;
import com.lnht.utils.OTPNumber;
import com.lnht.validator.AdmissionScoreValidator;
import com.lnht.validator.EducationProgramValidator;
import com.lnht.validator.FacultyValidator;
import com.lnht.validator.MajorValidator;
import java.util.Collection;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author minh-nguyen
 */
@Controller
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private Environment env;

    @GetMapping("/faculty")
    public String createView(Model model, HttpSession session, @RequestParam Map<String, Object> params, Authentication authentication) {

        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            if (auth.getAuthorities().iterator().next().toString().equals("ROLE_ADMIN")) {
                model.addAttribute("currentAdminRole", "true");
            }
            model.addAttribute("currentUserName", auth.getName());

        }

        String sortType = (String) params.get("sort");
        if (sortType == null) {
            model.addAttribute("sortType", "default");
        } else {
            if ("".equals(sortType)) {
                model.addAttribute("sortType", "default");
            }
            if ("asc".equals(sortType)) {
                model.addAttribute("sortType", "asc");
            }
            if ("desc".equals(sortType)) {
                model.addAttribute("sortType", "desc");
            }
        }
        String e = (String) params.get("current-tab");

        // faculty, major, educationProgram
        if (e == null) {
            e = (String) session.getAttribute("current-tab");
            if (e == null) {
                e = "faculty";
            }
        }

        model.addAttribute("currentTab", e);

        String pF = (String) params.get("faculty-page");
        String pM = (String) params.get("major-page");
        String pE = (String) params.get("education-program-page");
        String pA = (String) params.get("admission-score-page");

        int P1 = 1;
        int P2 = 1;
        int P3 = 1;
        int P4 = 1;
        if (pF != null) {
            P1 = Integer.parseInt(pF);
        } else {
            P1 = 1;
            params.put("faculty-page", "1");
        }
        if (pM != null) {

            P2 = Integer.parseInt(pM);
        } else {
            params.put("major-page", "1");
            P2 = 1;
        }
        if (pE != null) {
            P3 = Integer.parseInt(pE);
        } else {
            P3 = 1;
            params.put("education-program-page", "1");

        }
        if (pA != null) {
            P4 = Integer.parseInt(pA);
        } else {
            P4 = 1;
            params.put("admission-score-page", "1");

        }

        String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

        String page = (String) params.getOrDefault("page", String.valueOf(1));
        int page_size = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

        model.addAttribute("faculties", facultyService.getAll(params));
        model.addAttribute("faculties1", facultyService.getAllFaculty());
        model.addAttribute("majors1", facultyService.getAllMajor());
        model.addAttribute("educationPrograms1", facultyService.getAllEducationProgram());
        model.addAttribute("majors", facultyService.getAllMajor(params));
        model.addAttribute("educationPrograms", facultyService.getAllEducationProgram(params));
        model.addAttribute("admissionScores", facultyService.getAllAdmissionScore(params));

        System.out.println(facultyService.getAll(params));
        System.out.println(facultyService.getAllMajor(params));
        System.out.println(facultyService.getAllEducationProgram(params));
        System.out.println(facultyService.getAllAdmissionScore(params));

        model.addAttribute("facultyQuantity", Math.ceil(facultyService.countFaculty() * 1.0 / page_size));
        model.addAttribute("majorQuantity", Math.ceil(facultyService.countMajor() * 1.0 / page_size));
        model.addAttribute("educationProgramQuantity", Math.ceil(facultyService.countEducationProgram() * 1.0 / page_size));
        model.addAttribute("admissionScoreQuantity", Math.ceil(facultyService.countAdmissionScore() * 1.0 / page_size));
model.addAttribute("facultyQ", facultyService.countFaculty());
        model.addAttribute("majorQ", facultyService.countMajor());
        model.addAttribute("educationProgramQ", facultyService.countEducationProgram());
        model.addAttribute("admissionScoreQ", facultyService.countAdmissionScore());
        System.out.println(Math.ceil(facultyService.countFaculty() * 1.0 / page_size));
        System.out.println(Math.ceil(facultyService.countMajor() * 1.0 / page_size));
        System.out.println(Math.ceil(facultyService.countEducationProgram() * 1.0 / page_size));
        System.out.println(Math.ceil(facultyService.countAdmissionScore() * 1.0 / page_size));

        model.addAttribute("UID", OTPNumber.generateOTP());

        model.addAttribute("title", "Faculty");
        model.addAttribute("TinyMCE_Key", TinyMCEKey);
        model.addAttribute("currentFacultyPage", P1);
        model.addAttribute("currentMajorPage", P2);
        model.addAttribute("currentEducationProgramPage", P3);
        model.addAttribute("currentAdmissionScorePage", P4);

        return "faculty";
    }

    @PostMapping("/faculty")
    public String add(Model model, Authentication authentication, @ModelAttribute(value = "faculty") FacultyDTO f, HttpSession session, @RequestParam Map<String, Object> params, HttpServletRequest request, BindingResult result) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            FacultyDTO fDTO = new FacultyDTO();
            fDTO.setId((String) params.get("id"));
            fDTO.setNoidung((String) params.get("noidung"));
            fDTO.setTenkhoa((String) params.get("tenkhoa"));
            fDTO.setVideo((String) params.get("video"));

            FacultyValidator fV = new FacultyValidator();

            if (fV.validator(fDTO) == false) {
                String e = (String) params.get("current-tab");
                session.setAttribute("current-tab", e);
                params.put("current-tab", e);
                session.setAttribute("facultyErrors", fV.getErrors());
                session.setAttribute("createFacultyMessage", (String) params.get("id") + ", was not created");
                String prev = request.getHeader("Referer");
                if (prev.contains(fDTO.getId()) == true) {
//                    prev = prev.replace(String.valueOf(fDTO.getId()), "");
//                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
//                    prev = prev.concat("?current-tab=" + e);

                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev.replaceAll("current-tab=[^&]*", "current-tab=" + e);
                }

//                model.addAttribute("facultyErrors", fV.getErrors());
//                model.addAttribute("createFacultyMessage", f.getId() + ", was not created!");
//                return this.createView(model, session, params, authentication);
            } else {
                //
//            if (result.hasErrors()) {
//                return "redirect:/faculty";
//            }
                String facultyFormType = (String) params.get("faculty");
                String majorFormType = (String) params.get("major");
                String educationFormType = (String) params.get("educationProgram");

                if (facultyFormType != null) {
                    Khoa F = new Khoa();
                    F.setId(Integer.parseInt(f.getId()));
                    F.setTenkhoa(f.getTenkhoa());
                    F.setVideo(f.getVideo());
                    this.facultyService.postOrEditFaculty(F, params, request);
//                    model.addAttribute("createFacultyMessage", fDTO.getId() + " is created!");
//                    return this.createView(model, session, params, authentication);
                    session.setAttribute("createFacultyMessage", (String) params.get("id") + " is created!");
                    session.removeAttribute("facultyErrors");

                    String e = (String) params.get("current-tab");
                    session.setAttribute("current-tab", e);
                    params.put("current-tab", e);

                    String prev = request.getHeader("Referer");
                    if (prev.contains(fDTO.getId()) == true) {
                        prev = prev.replace(String.valueOf(fDTO.getId()), "");
                        prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
                        prev = prev.concat("?current-tab=" + e);

                        return "redirect:" + prev;
                    } else {
                        return "redirect:" + prev.replaceAll("current-tab=[^&]*", "current-tab=" + e);
                    }

                }

            }

        } else {
            return "error";
        }
        return null;

    }

    @PostMapping("/faculty/major")
    public String add2(Model model, Authentication authentication, @ModelAttribute(value = "major") MajorDTO n, HttpSession session, @RequestParam Map<String, Object> params, HttpServletRequest request, BindingResult result) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {

            MajorDTO dDTO = new MajorDTO();
            dDTO.setId((String) params.get("id"));
            dDTO.setKhoaid((String) params.get("khoaid"));
            dDTO.setTen((String) params.get("ten"));

            MajorValidator mValidator = new MajorValidator();
            if (mValidator.validate(dDTO) == false) {
                session.setAttribute("majorErrors", mValidator.getErrors());
                session.setAttribute("createMajorMessage", (String) params.get("id") + ", was not created!");
                String e = (String) params.get("current-tab");
                session.setAttribute("current-tab", e);
                params.put("current-tab", e);

                String prev = request.getHeader("Referer");
                if (prev.contains(dDTO.getId()) == true) {
//                    prev = prev.replace(String.valueOf(dDTO.getId()), "");
//                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
//                    prev = prev.concat("?current-tab=" + e);

                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev.replaceAll("current-tab=[^&]*", "current-tab=" + e);
                }

//                model.addAttribute("majorErrors", mValidator.getErrors());
//                model.addAttribute("createMajorMessage", dDTO.getId() + ", was not created!");
//                return this.createView(model, session, params, authentication);
            } else {
                String facultyFormType = (String) params.get("faculty");
                String majorFormType = (String) params.get("major");
                String educationFormType = (String) params.get("educationProgram");

                if (majorFormType != null) {
                    Nganh N = new Nganh();
                    N.setId(Integer.parseInt(n.getId()));
                    N.setKhoa(facultyService.getFacultyById(Integer.parseInt(n.getKhoaid())));
                    N.setTen(n.getTen());
                    this.facultyService.postOrEditMajor(N, params, request);
                    session.setAttribute("createMajorMessage", (String) params.get("id") + " is created!");
                    session.removeAttribute("majorErrors");

                    String e = (String) params.get("current-tab");
                    session.setAttribute("current-tab", e);
                    params.put("current-tab", e);

                    String prev = request.getHeader("Referer");
                    if (prev.contains(dDTO.getId()) == true) {
                        prev = prev.replace(String.valueOf(dDTO.getId()), "");
                        prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
                        prev = prev.concat("?current-tab=" + e);
                        return "redirect:" + prev;
                    } else {
                        return "redirect:" + prev.replaceAll("current-tab=[^&]*", "current-tab=" + e);
                    }

//                    model.addAttribute("createMajorMessage", dDTO.getId() + ", is created!");
//                    return this.createView(model, session, params, authentication);
                }
            }

        } else {
            return "error";
        }
        return null;
    }

    @PostMapping("/faculty/education-program")
    public String add1(Model model, Authentication authentication, @ModelAttribute(value = "educationProgram") EducationProgramDTO c, HttpSession session, @RequestParam Map<String, Object> params, HttpServletRequest request, BindingResult result) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {

            EducationProgramDTO eDTO = new EducationProgramDTO();
            eDTO.setId((String) params.get("id"));
            eDTO.setMota((String) params.get("mota"));
            eDTO.setTen((String) params.get("ten"));

            EducationProgramValidator eValidator = new EducationProgramValidator();
            if (eValidator.validate(eDTO) == false) {

                session.setAttribute("educationProgramErrors", eValidator.getErrors());
                session.setAttribute("createEducationProgramMessage", (String) params.get("id") + ", was not created!");
                String e = (String) params.get("current-tab");
                session.setAttribute("current-tab", e);
                params.put("current-tab", e);

                String prev = request.getHeader("Referer");
                if (prev.contains(eDTO.getId()) == true) {
//                    prev = prev.replace(String.valueOf(eDTO.getId()), "");
//                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
//                    prev = prev.concat("?current-tab=" + e);
                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev.replaceAll("current-tab=[^&]*", "current-tab=" + e);
                }

//                model.addAttribute("educationProgramErrors", eValidator.getErrors());
//                model.addAttribute("createEducationProgramMessage", eDTO.getId() + ", was not created!");
//                return this.createView(model, session, params, authentication);
            } else {
                String facultyFormType = (String) params.get("faculty");
                String majorFormType = (String) params.get("major");
                String educationFormType = (String) params.get("educationProgram");
                if (educationFormType != null) {
                    Chuongtrinhdaotao C = new Chuongtrinhdaotao();
                    C.setId(Integer.parseInt(c.getId()));
                    C.setTen(c.getTen());
                    C.setMota(c.getMota());
                    this.facultyService.postOrEditEducationProgram(C, params, request);
                    session.setAttribute("createEducationProgramMessage", (String) params.get("id") + ", is created!");
                    session.removeAttribute("educationProgramErrors");

                    String e = (String) params.get("current-tab");
                    session.setAttribute("current-tab", e);
                    params.put("current-tab", e);

                    String prev = request.getHeader("Referer");
                    if (prev.contains(eDTO.getId()) == true) {
                        prev = prev.replace(String.valueOf(eDTO.getId()), "");
                        prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
                        prev = prev.concat("?current-tab=" + e);
                        return "redirect:" + prev;
                    } else {
                        return "redirect:" + prev.replaceAll("current-tab=[^&]*", "current-tab=" + e);
                    }

//                    model.addAttribute("createEducationProgramMessage", eDTO.getId() + ", is created!");
//                    return this.createView(model, session, params, authentication);
                }
            }
        } else {
            return "error";
        }
        return null;

    }

    @PostMapping("/faculty/admission-score")
    public String add1(Model model, Authentication authentication, @ModelAttribute AdmissionScoreDTO c, HttpSession session, @RequestParam Map<String, Object> params, HttpServletRequest request) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            String e = (String) params.get("current-tab");
            session.setAttribute("current-tab", e);
            params.put("current-tab", e);

            AdmissionScoreDTO aScore = c;
            aScore.setId((String) params.get("id"));
            aScore.setDiem((String) params.get("diem"));
            aScore.setNamhoc((String) params.get("namhoc"));
            aScore.setKhoaid((String) params.get("khoaid"));
            aScore.setNganhid((String) params.get("nganhid"));
            aScore.setChuongtrinhdaotaoid((String) params.get("chuongtrinhdaotaoid"));

            AdmissionScoreValidator asValidate = new AdmissionScoreValidator();
            if (asValidate.validator(aScore) == false) {
                session.setAttribute("createAdmissionScoreMessage", (String) params.get("id") + ", was not created!");
                session.setAttribute("admissionScoreErrors", asValidate.getErrors());
                String prev = request.getHeader("Referer");
                if (prev.contains(aScore.getId()) == true) {
//                    prev = prev.replace(aScore.getId(), "");
//                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
//                    prev = prev.concat("?current-tab=" + e);
                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev.replaceAll("current-tab=[^&]*", "current-tab=" + e);
                }

//                model.addAttribute("createAdmissionScoreMessage", aScore.getId() + ", is not created!");
//                model.addAttribute("admissionScoreErrors", asValidate.getErrors());
//                return this.createView(model, session, params, authentication);
            } else {
                String facultyFormType = (String) params.get("faculty");
                String majorFormType = (String) params.get("major");
                String educationFormType = (String) params.get("educationProgram");
                String admissionScoreFormType = (String) params.get("admissionScore");

                if (admissionScoreFormType != null) {
                    Diemtrungtuyen C = new Diemtrungtuyen();
                    C.setId(Integer.parseInt(c.getId()));
                    C.setDiem(Double.valueOf(c.getDiem()));
                    C.setChuongtrinhdaotao(facultyService.getEducationProgramById(Integer.parseInt(c.getChuongtrinhdaotaoid())));
                    C.setKhoa(facultyService.getFacultyById(Integer.parseInt(c.getKhoaid())));
                    C.setNganh(facultyService.getMajorById(Integer.parseInt(c.getNganhid())));
                    C.setNamhoc(Integer.parseInt(c.getNamhoc()));
                    this.facultyService.postOrEditAdmissionScore(C, params, request);
                    session.setAttribute("createAdmissionScoreMessage", (String) params.get("id") + ", is created!");
                    session.removeAttribute("admissionScoreErrors");

                    String prev = request.getHeader("Referer");
                    if (prev.contains(aScore.getId()) == true) {
                        prev = prev.replace(aScore.getId(), "");
                        prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
                        prev = prev.concat("?current-tab=" + e);
                        return "redirect:" + prev;
                    } else {
                        return "redirect:" + prev.replaceAll("current-tab=[^&]*", "current-tab=" + e);
                    }

//                    model.addAttribute("createAdmissionScoreMessage", aScore.getId() + ", is created!");
//                    return this.createView(model, session, params, authentication);
                }
            }
        } else {
            return "error";
        }
        return null;
    }

    @GetMapping("/faculty/{id}")
    public String getFaculty(Authentication authentication, Model model, HttpSession session, @PathVariable(value = "id") int id) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

            Khoa t = this.facultyService.getFacultyById(id);
            model.addAttribute("UID", OTPNumber.generateOTP());

            model.addAttribute("faculty", t);
            model.addAttribute("title", "Detail Faculty");
            model.addAttribute("TinyMCE_Key", TinyMCEKey);

            session.setAttribute("current-tab", "faculty");
            return "detailFaculty";
        } else {
            return "error";
        }

    }

    @GetMapping("/faculty/major/{id}")
    public String getMajor(Authentication authentication, Model model, HttpSession session, @PathVariable(value = "id") int id) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

            Nganh t = this.facultyService.getMajorById(id);

            model.addAttribute("major", t);
            model.addAttribute("title", "Detail Major");
            model.addAttribute("TinyMCE_Key", TinyMCEKey);
            model.addAttribute("faculties1", facultyService.getAllFaculty());
            session.setAttribute("current-tab", "major");

            return "detailMajor";
        } else {
            return "error";
        }

    }

    @GetMapping("/faculty/education-program/{id}")
    public String getEducationProgram(Authentication authentication, Model model, HttpSession session, @PathVariable(value = "id") int id) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

            Chuongtrinhdaotao t = this.facultyService.getEducationProgramById(id);

            model.addAttribute("educationProgram", t);
            model.addAttribute("title", "Detail Education Program");
            model.addAttribute("TinyMCE_Key", TinyMCEKey);
            session.setAttribute("current-tab", "educationProgram");

            return "detailEducationProgram";
        } else {
            return "error";
        }

    }

    @GetMapping("/faculty/admission-score/{id}")
    public String getAdmissionScore(Authentication authentication, Model model, HttpSession session, @PathVariable(value = "id") int id) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

            Diemtrungtuyen t = this.facultyService.getAdmissionScoreById(id);

            model.addAttribute("admissionScore", t);
            model.addAttribute("faculties1", facultyService.getAllFaculty());
            model.addAttribute("majors1", facultyService.getAllMajor());
            model.addAttribute("educationPrograms1", facultyService.getAllEducationProgram());

            model.addAttribute("title", "Detail Admission Score");
            model.addAttribute("TinyMCE_Key", TinyMCEKey);
            session.setAttribute("current-tab", "admissionScore");

            return "detailAdmissionScore";

        } else {
            return "error";
        }

    }

    @DeleteMapping("/faculty/admission-score/delete/{id}")
    public String deleteAdmissionScore(Model model, HttpSession session, @RequestParam Map<String, Object> params, Authentication authentication, @PathVariable(value = "id") int id) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            this.facultyService.deleteAdmisisonScore(id);

            session.setAttribute("current-tab", "admissionScore");
            params.put("current-tab", "admissionScore");
            session.setAttribute("createAdmissionScoreMessage", id + ", was deleted!");
            return this.createView(model, session, params, authentication);

        } else {
            return "error";
        }

    }

    @DeleteMapping("/faculty/delete/{id}")
    public String deleteFaculty(Authentication authentication, Model model, HttpSession session, @RequestParam Map<String, Object> params, @PathVariable(value = "id") int id) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            this.facultyService.deleteFaculty(id);
            session.setAttribute("current-tab", "faculty");
            params.put("current-tab", "faculty");
            session.setAttribute("createFacultyMessage", id + ", was deleted!");
            return this.createView(model, session, params, authentication);

        } else {
            return "error";
        }
    }

    @DeleteMapping("/faculty/major/delete/{id}")
    public String deleteMajor(Authentication authentication, Model model, HttpSession session, @RequestParam Map<String, Object> params, @PathVariable(value = "id") int id) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            this.facultyService.deleteMajor(id);
            session.setAttribute("current-tab", "major");
            params.put("current-tab", "major");
            session.setAttribute("createMajorMessage", id + ", was deleted!");
            return this.createView(model, session, params, authentication);

        } else {
            return "error";
        }
    }

    @DeleteMapping("/faculty/education-program/delete/{id}")
    public String deleteEducationProgram(Model model, Authentication authentication, HttpSession session, @RequestParam Map<String, Object> params, @PathVariable(value = "id") int id) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            this.facultyService.deleteEducationProgram(id);
            session.setAttribute("current-tab", "major");
            params.put("current-tab", "major");
            session.setAttribute("createEducationProgramMessage", id + ", was deleted!");
            return this.createView(model, session, params, authentication);

        } else {
            return "error";
        }
    }
}
