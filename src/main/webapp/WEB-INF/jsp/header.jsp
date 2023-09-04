 <security:authorize access="isAuthenticated()">
        <security:authentication property="principal.username" var="user"/>


     <security:authentication property="principal.authorities" var="role"/>




     <security:authorize access="hasRole('ADMIN')" >

            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

                <!-- Links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/admin/getalluser">Show user</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                    <li class="nav-item" >

                        <h4  class=" text-success"> User name: ${user}  </h4>
                    </li>  <li class="nav-item" >

                    <h4  class=" text-success"> Role name: ${role}  </h4>
                </li>

                </ul>

            </nav>
        </security:authorize>
     <security:authorize access="hasRole('USER')" >
         <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

         <!-- Links -->
         <ul class="navbar-nav">
             <li class="nav-item">
                 <a class="nav-link" href="/">Home</a>
             </li>
             <li class="nav-item">
                 <a class="nav-link" href="/book/list">Show book</a>
             </li>
             <li class="nav-item">
                 <a class="nav-link" href="/logout">Logout</a>
             </li>

             <li class="nav-item" >

                 <h4  class=" text-success"> User name: ${user}  </h4>
             </li>  <li class="nav-item" >

                 <h4  class=" text-success"> Role name: ${role}  </h4>
             </li>
         </ul>
         </nav>

     </security:authorize>
     <security:authorize access="hasRole('PUBLISHER')" >

         <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

             <!-- Links -->
             <ul class="navbar-nav">
                 <li class="nav-item">
                     <a class="nav-link" href="/">Home</a>
                 </li>
                 <li class="nav-item">
                     <a class="nav-link" href="/publisher/add">Add Book</a>
                 </li>
                 <li class="nav-item">
                     <a class="nav-link" href="/publisher/delete">Delete book</a>
                 </li>
                 <li class="nav-item">
                     <a class="nav-link" href="/publisher/edit">Edit Book</a>
                 </li>
                 <li class="nav-item">
                     <a class="nav-link" href="/book/list">List of Book</a>
                 </li>
                 <li class="nav-item">
                     <a class="nav-link" href="/book/get-details">BookDetail</a>
                 </li>
                 <li class="nav-item">
                     <a class="nav-link" href="/logout">Logout</a>
                 </li>
                 <li class="nav-item" >

                     <h4  class=" text-success"> User name: ${user}  </h4>
                 </li>  <li class="nav-item" >

                 <h4  class=" text-success"> Role name: ${role}  </h4>
             </li>

             </ul>

         </nav>
     </security:authorize>

 </security:authorize>
<security:authorize access="!isAuthenticated()">

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/book/list">Show book</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/signup">Signup</a>
            </li>


        </ul>
    </nav>
</security:authorize>
