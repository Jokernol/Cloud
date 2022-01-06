<li class="media mt-4 mb-4">
    <a>
        <img src="../../../public/static/Avatar/${chat.senderId}.jpg" onerror="this.src='../../../public/static/Avatar/fang.jpg'" alt="{{ $user->name }}" class="mr-3 gravatar"/>
        <h5 class="mt-0 mb-1" style="color: black">${requestScope.receiver.name}</h5>
    </a>
    <div class="media-body">
        <h5 class="mt-0 mb-1">  <small> /  ${chat.time} </small></h5>
        ${chat.content}
    </div>
</li>
