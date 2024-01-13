<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservation Form</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">

</head>
<body>

<div class="container mt-5">
    <h2>Reservation Form</h2>
    <form action="processReservation.jsp" method="post" class="needs-validation" novalidate>
        <!-- Client Information -->
        <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" required>
            <div class="invalid-feedback">Please enter your first name.</div>
        </div>

        <div class="form-group">
            <label for="familyName">Family Name</label>
            <input type="text" class="form-control" id="familyName" name="familyName" required>
            <div class="invalid-feedback">Please enter your family name.</div>
        </div>

        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" required>
            <div class="invalid-feedback">Please enter your address.</div>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
            <div class="invalid-feedback">Please enter a valid email address.</div>
        </div>

        <div class="form-group">
            <label for="phoneNumber">Phone Number</label>
            <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" required>
            <div class="invalid-feedback">Please enter your phone number.</div>
        </div>

        <!-- Hidden Inputs -->
        <input type="hidden" name="roomId" value="${param.roomId}">
        <input type="hidden" name="checkinDate" value="${param.checkinDate}">
        <input type="hidden" name="checkoutDate" value="${param.checkoutDate}">

        <!-- Validate Reservation Button -->
        <button type="submit" class="btn btn-primary">Validate Reservation</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-eMNCO7jFh0pJ0Lfxswn9I1D5Z+STHKUJh9aIuRfhEX6qVUEshpMFL2JvHwZ86j6r"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+Wy+yoFy38MVBnZO5BAsqXM2Q=="
        crossorigin="anonymous"></script>

<script>
    // Bootstrap validation script
    (function () {
        'use strict';

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation');

        // Loop over them and prevent submission
        Array.from(forms).forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    })();
</script>

</body>
</html>
