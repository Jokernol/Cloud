<li class="media mt-4 mb-4">
    <div class="11" style="display: flex;justify-content: flex-end;flex-wrap: nowrap;width: 100%">
        <div class="media-body" style="display: flex;flex-direction: column">
            <h5 class="mt-0 mb-1" style="display: flex;justify-content: flex-end">
                <small> ${chat.time} /</small>
            </h5>
            <span style="display: flex;justify-content: flex-end">
                ${chat.content}
</span>
        </div>
        <a>
            <img src="../../../public/static/Avatar/${sessionScope.user.id}.jpg" onerror="this.src='/upload/static/Avatar/default.jpg'" alt="{{ Auth::user()->name }}" class="mr-3 gravatar"/>
            <h5 class="mt-0 mb-1" style="color: black">${sessionScope.user.name}</h5>
        </a>
    </div>
</li>
