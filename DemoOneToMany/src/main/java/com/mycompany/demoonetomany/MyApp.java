package com.mycompany.demoonetomany;

import com.mycompany.demoonetomany.dao.AttachmentDao;
import com.mycompany.demoonetomany.dao.PersonnelDao;
import com.mycompany.demoonetomany.dao.ProposalDao;
import com.mycompany.demoonetomany.entity.Attachment;
import com.mycompany.demoonetomany.entity.Personnel;
import com.mycompany.demoonetomany.entity.Proposal;
import com.mycompany.demoonetomany.entity.QualificationLevel;
import com.mycompany.demoonetomany.entity.QualificationLevel.qualificationLevel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author namrata
 */
public class MyApp {

    public static void main(String[] args) {
        ProposalDao proposalDao = new ProposalDao();
        AttachmentDao attachmentDao = new AttachmentDao();
        PersonnelDao personnelDao = new PersonnelDao();

//-------------insert-------------------------
        QualificationLevel ql;
        List<Personnel> pl = new ArrayList<Personnel>();
        List<Attachment> al = new ArrayList<Attachment>();
        ql = new QualificationLevel(qualificationLevel.Beginner);
        Date date = new Date();
        Attachment a = new Attachment("test", "12", new Timestamp(date.getTime()), (byte) 3);
        Personnel personnel = new Personnel("namrata", ql, "9098989898");
        pl.add(personnel);
        al.add(a);
        Attachment a1 = new Attachment("test1", "12", new Timestamp(date.getTime()), (byte) 3);
        Personnel personnel1 = new Personnel("namrata1", ql, "9098989898");
        pl.add(personnel1);
        al.add(a1);
        Proposal proposal = new Proposal("project1", "java", pl, al);
        proposalDao.insert(proposal);

//------------------Update-----------------------------        
        Proposal p2 = new Proposal("project4", "java3");
        Attachment a2 = new Attachment("test1", "123", new Timestamp(date.getTime()), (byte) 4);
        Personnel personnel2 = new Personnel("namrata2", ql, "9098989908");
        attachmentDao.update(Long.valueOf(1), a2);
        proposalDao.update(Long.valueOf(1), p2);
        personnelDao.update(Long.valueOf(1), personnel2);

//---------------Delete---------------------
        proposalDao.delete(Long.valueOf(1));
        personnelDao.delete(Long.valueOf(1));
        attachmentDao.delete(Long.valueOf(1));
    }
}
