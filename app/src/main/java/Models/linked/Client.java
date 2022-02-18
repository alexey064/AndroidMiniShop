package Models.linked;

import Models.simple.Department;
import Models.simple.Type;

public class Client {
    public Client()
    {

    }

    public int Id;
    public String NickName;
    public String Email;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPostId() {
        return PostId;
    }

    public void setPostId(int postId) {
        PostId = postId;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

    public Models.simple.Department getDepartment() {
        return Department;
    }

    public void setDepartment(Models.simple.Department department) {
        Department = department;
    }

    public Type getPost() {
        return Post;
    }

    public void setPost(Type post) {
        Post = post;
    }

    public String FullName;
    public String Phone;
    public String Address;
    public int PostId;
    public int DepartmentId;

    public Department Department;
    public Type Post;
}