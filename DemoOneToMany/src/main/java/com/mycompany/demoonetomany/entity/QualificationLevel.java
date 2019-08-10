package com.mycompany.demoonetomany.entity;

import javax.persistence.Embeddable;

/**
 *
 * @author namrata
 */
@Embeddable
public class QualificationLevel {

    public enum qualificationLevel {
        Beginner, Intermediate, Pro
    }
    private qualificationLevel ql;

    public QualificationLevel() {

    }

    public QualificationLevel(qualificationLevel ql) {
        this.ql = ql;
    }

    public qualificationLevel getQl() {
        return ql;
    }

    public void setQl(qualificationLevel ql) {
        this.ql = ql;
    }

}
