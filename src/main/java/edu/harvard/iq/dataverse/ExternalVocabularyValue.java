/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.harvard.iq.dataverse;

import edu.harvard.iq.dataverse.util.BundleUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.MissingResourceException;

import javax.json.JsonObject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author qqmyers
 */
@Entity
@Table(indexes = { @Index(columnList = "datasetfieldtype_id"), @Index(columnList = "displayorder") })
public class ExternalVocabularyValue implements Serializable {

    public ExternalVocabularyValue() {
    }

    public ExternalVocabularyValue(String uri, String value) {
        this.uri = uri;
        this.value = value;
    }

    @Id
    @Column(columnDefinition = "TEXT", nullable = false)
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Column(columnDefinition = "TEXT", nullable = true)
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private Timestamp lastUpdateDate;

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.uri != null ? this.uri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ExternalVocabularyValue)) {
            return false;
        }
        ExternalVocabularyValue other = (ExternalVocabularyValue) object;
        return Objects.equals(getUri(), other.getUri());
    }

    @Override
    public String toString() {
        return "edu.harvard.iq.dataverse.ExternalVocabularyValue[ uri=" + uri + " ]";
    }
}
