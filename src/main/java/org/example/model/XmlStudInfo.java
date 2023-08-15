package org.example.model;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlStudInfo {

    public XmlStudInfo() {
    }

    @XmlElementWrapper(name = "universityList")
    @XmlElement(name = "universityInfo")
    private List<University> universityList;

    @XmlElementWrapper(name = "studentList")
    @XmlElement(name = "studentInfo")
    private List<Student> studentList;

    @XmlElementWrapper(name = "statisticsList")
    @XmlElement(name = "statisticInfo")
    private List<Statistics> statisticsList;

    @XmlElement(name = "processedAt")
    private Date processDate;

    public List<University> getUniversityList() {
        return universityList;
    }

    public XmlStudInfo setUniversityList(List<University> universityList) {
        this.universityList = universityList;
        return this;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public XmlStudInfo setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public XmlStudInfo setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public XmlStudInfo setProcessDate(Date processDate) {
        this.processDate = processDate;
        return this;
    }

}
