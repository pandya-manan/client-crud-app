## 📘 Client Management CRUD App (Spring Boot + Thymeleaf)

This is a simple and elegant **Client Management System** built using:
- **Spring Boot**
- **Thymeleaf**
- **MySQL**
- **ModelMapper**
- **Bootstrap-style CSS (custom)**

It supports full **CRUD operations** with a polished user interface.

---

### 🔧 Features

- ✅ Add New Clients  
- ✅ View All Clients (Paginated UI)
- ✅ Update Existing Client  
- ✅ Delete Client  
- ✅ Flash messages with auto-hide  
- ✅ Form validation  
- ✅ ModelMapper for DTO → Entity mapping  

---

### 📸 UI Highlights

- Stylish form with smooth input layout
- Flash messages for success, update, and delete actions
- Paginated cards layout with update/delete buttons
- Auto-hiding notification messages

---

### 🗃️ Database Schema (MySQL)

```sql
CREATE TABLE clients (
    client_id INT AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR(100) NOT NULL,
    client_address VARCHAR(255),
    client_mobile_number VARCHAR(20),
    client_age INT
);
```

---

### 🚀 Running the App

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-repo/client-crud-app.git
   cd client-crud-app
   ```

2. **Configure `application.properties`**

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

3. **Run the Spring Boot App**

   ```bash
   ./mvnw spring-boot:run
   ```

4. **Visit in Browser**

   ```
   http://localhost:8080/clients
   ```

---

### 📁 Folder Structure

```
src
 └── main
     ├── java
     │    └── com.thymeleaf.demo
     │         ├── controller
     │         ├── dto
     │         ├── entity
     │         ├── repository
     │         └── service
     └── resources
          ├── templates
          │    ├── clients.html
          │    └── client_form.html
          └── application.properties
```

---

### ✅ Future Improvements

- Add validations using `@Valid` and `BindingResult`
- Integrate Bootstrap for better responsiveness
- Convert to REST + React (optional)
- Add unit tests and Dockerize

---

### 🙌 Acknowledgements

Thanks to the Spring Boot and Thymeleaf community!  

---

