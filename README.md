Authour: Đỗ Gia Huy MSSV: 52200011

  Dự án SpringCommerce này được xây dựng để đáp ứng nhu cầu bán sản phẩm của khách hàng dưới dạng MVP (Minimum
Viable Product) với các tính năng sau:

- Hiển thị danh sách sản phẩm và lọc theo tiêu chí.
- Xem chi tiết sản phẩm, thêm sản phẩm vào giỏ hàng.
- Thanh toán giỏ hàng.
- Admin quản lý sản phẩm.
- Khách hàng tạo tài khoản để lưu trữ các thông tin mua hàng cơ bản.
- Mua hàng không cần tài khoản.
- Xác thực, phân quyền.

  Ứng dụng xậy dựng dựa trên:
- Frontend:
  + HTML
  + CSS
  + Javascript
- Backend:
  + Spring Boot.
  + Spring Security(Authentication, Authorization, JWT).

  Ứng dụng được xây dựng theo các nguyên tắc và cấu trúc:
- SOLID: Dảm bảo dự án dễ bảo trì, mở rộng:
    + Single Responsibility Principle: Mỗi class đảm nhiệm một vai trò riêng biệt.
    + Dependency Inversion Principle: Sử dụng Dependency Injection trong tầng service.
- Mô hình MVC: Phân chia dự án làm ba phần Model, View, Controller. Mỗi phần đảm nhiệm một vai trò riêng biệt.
    + View: Đảm nhiệm frontend(HTML, CSS, JS)
    + Controller: Chịu trách nhiệm điều hướng người dùng.
    + Model: Chịu trách nhiệm đối với các thao tác với cơ sở dữ liệu.
- API Restful: Các endpoint tuân thủ nguyên tắc REST, dễ tích hợp và mở rộng.
- Kiến trúc phân lớp: Tách biệt rõ ràng giữa Controller, Service, và Repository.
- Repository Pattern: Quản lý thao tác cơ sở dữ liệu.

Để khởi chạy ứng dụng trên local, thực hiện theo các bước sau:
- Máy tính phải đảm bảo có JDK 17 trở lên.
- Đã cài đặt Tomcat Server.
- Tải Docker Desktop về máy.
- Tải thư mục chứa dự án về máy.
- Mở thư mục chứa file "docker-compose.yml".
- Mở Terminal và thực hiện lệnh "docker compose up".
- Kiểm tra xem database đã chạy trên Docker Desktop chưa.
- Khởi động IDE (eg. IntelliJ) và khởi chạy thư mục chứa dự án.
- Truy cập vào localhost:8080.
- Có thể test với việc không đăng nhập hoặc sử dụng tài khoản test là:
  + ADMIN: email: admin@gmail.com; password: admin
  + USER: email: test@gmail.com; password: test

Các Restful API của dự án:
- Login:
![image](https://github.com/user-attachments/assets/f1d205ec-505a-4766-8339-05d0a4dfdbbb)
- Register:
![image](https://github.com/user-attachments/assets/82f48760-e910-4b77-be64-0ae3c07b35a6)
- Get all products:
![image](https://github.com/user-attachments/assets/77fc4f35-203b-42e3-9947-bac9349e47f8)
- Get product by id:
![image](https://github.com/user-attachments/assets/54524ed8-30b5-47b2-8122-63bd8082cd76)
- Create product:
Header: Authorization Bearer Token (Token của người dùng admin)
![image](https://github.com/user-attachments/assets/3bf5339f-a173-413b-9b72-315d3814f763)
- Update product by id:
Header: Authorization Bearer Token (Token của người dùng admin)
![image](https://github.com/user-attachments/assets/aada1169-8670-41f8-96c2-650745fe7d31)
- Delete product by id:
Header: Authorization Bearer Token (Token của người dùng admin)
![image](https://github.com/user-attachments/assets/61194010-5ff1-4c26-a44c-dbf7e8456e68)
- Search product by criteria:
![image](https://github.com/user-attachments/assets/5e2f57c6-3d56-40fa-a198-f9acff613a4b)
- Search product by name:
![image](https://github.com/user-attachments/assets/ab93cf36-3b2c-4085-83fe-90238c08766d)
- Get all categories:
![image](https://github.com/user-attachments/assets/1f5f17f2-9e41-4ca5-a886-332568611f12)
- Get category by id:
![image](https://github.com/user-attachments/assets/e07148b3-f750-457d-b302-32e6fd9fdf8b)








