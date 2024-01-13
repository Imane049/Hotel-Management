<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservation Recap</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>

<div class="container mt-5">
    <h2>Reservation Recap</h2>

    <div class="card mt-4">
        <div class="card-body">
            <p>Room Number: 1</p>
            <p>Check-in Date:2024-01-12</p>
            <p>Check-out Date: 2024-01-20</p>
            <p>First Name: Imane</p>
            <p>Family Name: Barakate</p>
            <p>Address: adresse imane</p>
            <p>Email: ibarakate0@gmail.com</p>
            <p>Phone Number: 0629991607</p>
        </div>
    </div>

    <form action="generatePdf" method="post">
        <input type="hidden" name="roomId" value="${roomId}">
        <input type="hidden" name="checkinDate" value="${checkinDate}">
        <input type="hidden" name="checkoutDate" value="${checkoutDate}">
        <input type="hidden" name="firstName" value="${firstName}">
        <input type="hidden" name="familyName" value="${familyName}">
        <input type="hidden" name="address" value="${address}">
        <input type="hidden" name="email" value="${email}">
        <input type="hidden" name="phoneNumber" value="${phoneNumber}">
        <button type="submit" class="btn btn-primary mt-3">Download PDF</button>
        <button type="submit" class="btn btn-primary mt-3">Send Email</button>
        
    </form>

</div>

<!-- Include Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-eMNCO7jFh0pJ0Lfxswn9I1D5Z+STHKUJh9aIuRfhEX6qVUEshpMFL2JvHwZ86j6r"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+Wy+yoFy38MVBnZO5BAsqXM2Q=="
        crossorigin="anonymous"></script>

</body>
</html>
