package com.example.petshop.model

sealed class Screen(val route: String, val title: String) {
    object HomePage : Screen(route = "home_page", title = "Trang chủ")
    object NotificationScreen : Screen(route = "notification", title = "Thông báo")
    object ShoppingCartScreen : Screen(route = "shopping_cart", title = "Giỏ hàng")
    object ProfileScreen : Screen(route = "profile", title = "Profile")
    object EditProfileScreen : Screen(route = "edit_profile", title = "Sửa thông tin")
    object CheckoutScreen : Screen(route = "check_out", title = "Thanh toán")
    object ShipmentStateScreen1 : Screen(route = "shipment_state_1", title = "Đơn hàng")
    object ShipmentStateScreen2 : Screen(route = "shipment_state_2", title = "Đơn hàng")
    object LoadingCheckout : Screen(route = "loading_checkout", title = "Đang thanh toán")
    object TransactionScreen : Screen(route = "transaction", title = "Thông tin giao dịch")
    object FollowShipping : Screen(route = "follow_shipping/{orderId}", title = "Theo dõi đơn hàng") {
        fun createRoute(orderId: String) = "follow_shipping/$orderId"
    }
    object SelectPayMethod : Screen(route = "select_pay_method", title = "Phương thức thanh toán")
    object SelectVoucher : Screen(route = "select_voucher", title = "Voucher")
    object ProDuctDetail : Screen(route = "product_detail", title = "Product Detail ??")
}
