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

Các Restful API của dự án:
- User:
+ **Register User**:<br>
  **URL**: /api/user/register<br>
  **Method**: POST<br>
  **Request Body**:<br>
  <div>{<br>
    "email": "string",<br>
    "name": "string",<br>
    "password": "string"<br>
  }<br></div>
  Response:<br>
  Status: 201 Created<br>
  Body:<br>
  {<br>
    "message": "User registered successfully",<br>
    "data": {<br>
      "id": "long",<br>
      "email": "string",<br>
      "name": "string"<br>
    }<br>
  }<br>
  Status: 400 Bad Request<br>
  Body:<br>
  {<br>
  "message": "Error message",<br>
  "data": null<br>
  }<br>
  {
    "message": "Error message",
    "data": null
  }

  
