package org.smart4j.chapters2.model;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

/**
 * 客户
 */
public class Customer {
    /**
     * id
     *
     */
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 客户名称
     */
    private String name;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 邮箱地址
     *
     */
    private String email;
    /**
     * 备注
     */
    private String remark;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", concact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
