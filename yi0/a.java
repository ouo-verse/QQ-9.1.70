package yi0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ECSchemeExtUserDataMap;
import com.tencent.ecommerce.base.router.api.IECRouterFilter;
import com.tencent.ecommerce.base.router.api.IECRouterLauncher;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECFloatCommonDetailBulletinFragment;
import com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment;
import com.tencent.ecommerce.biz.comment.ECBuyerOrderCommentFragment;
import com.tencent.ecommerce.biz.commission.detail.ECCommissionDetailFragment;
import com.tencent.ecommerce.biz.commission.forecast.ECCommissionForecastDetailListFragment;
import com.tencent.ecommerce.biz.commission.overview.ECCommissionOverviewFragment;
import com.tencent.ecommerce.biz.consulthistory.ECConsultHistoryFragment;
import com.tencent.ecommerce.biz.coupon.myshopping.ECMyShoppingActionSheetFragment;
import com.tencent.ecommerce.biz.customerservice.ECCustomerServiceFragment;
import com.tencent.ecommerce.biz.detail.fragment.ECDetailCustomPageFragment;
import com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment;
import com.tencent.ecommerce.biz.detail.fragment.ECShopDetailDistributionFragment;
import com.tencent.ecommerce.biz.detail.fragment.ECShopProductCommentPageFragment;
import com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailOffSaleFragment;
import com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment;
import com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailSkuInfoFragment;
import com.tencent.ecommerce.biz.detail.utils.e;
import com.tencent.ecommerce.biz.goodscenter.ECGoodsCenterFragment;
import com.tencent.ecommerce.biz.hippy.ECBaseHippyFragment;
import com.tencent.ecommerce.biz.hr.ECHRFragment;
import com.tencent.ecommerce.biz.live.ui.ECLiveGameSelectGoodsTypeFragment;
import com.tencent.ecommerce.biz.live.ui.ECLiveWindowMainFragment;
import com.tencent.ecommerce.biz.logistics.ECLogisticsTraceFragment;
import com.tencent.ecommerce.biz.logistics.ECSubmitLogisticsFragment;
import com.tencent.ecommerce.biz.mainpage.ECMainPageFragment;
import com.tencent.ecommerce.biz.orders.address.ECAddressManagerFragment;
import com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment;
import com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListContainerFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.searchpage.ECBuyerOrderSearchFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitLauncherFragment;
import com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderContainerFragment;
import com.tencent.ecommerce.biz.orders.sellerorders.searchpage.ECSellerOrderSearchFragment;
import com.tencent.ecommerce.biz.productcenter.fragment.ECSelectProductFragment;
import com.tencent.ecommerce.biz.productcenter.fragment.ECSelectProductSearchFragment;
import com.tencent.ecommerce.biz.productpromotion.fragment.ECPromotionFloatWindow;
import com.tencent.ecommerce.biz.register.b;
import com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterAgreementFragment;
import com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterAuthorizeFragment;
import com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterIntroFragment;
import com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterUserInfoFragment;
import com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceSettleAuthenticationFragment;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeQualificationFragment;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSearchFragment;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSearchResultFragment;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSecondProductListFragment;
import com.tencent.ecommerce.biz.shoplist.ECQShopPromoteListFragment;
import com.tencent.ecommerce.biz.showwindow.editor.ui.view.ECProductCardEditorFragment;
import com.tencent.ecommerce.biz.showwindow.fragment.ECLiveQShopShowWindowFragment;
import com.tencent.ecommerce.biz.showwindow.fragment.ECQGroupWindowFragment;
import com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment;
import com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowSearchFragment;
import com.tencent.ecommerce.biz.transactiondata.ECTransactionDataFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;
import tl.h;
import xi0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0006H\u0007J&\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007JL\u0010\u0019\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007J8\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J@\u0010#\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0 2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007J&\u0010$\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J*\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010*\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\b\u0010+\u001a\u00020\u0010H\u0002J\u0012\u0010-\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0010H\u0002R2\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100.j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010`/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u00104\u00a8\u00068"}, d2 = {"Lyi0/a;", "", "", "d", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "", "l", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Bundle;", "bundle", "", "e", "", "Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "router", "o", "params", "v", "r", "extUserData", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "callback", ReportConstant.COSTREPORT_PREFIX, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "u", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "fragment", "p", "k", "c", "g", "j", "i", "arguments", h.F, "b", "launcher", "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "routerMap", "Lcom/tencent/ecommerce/biz/router/a;", "Lcom/tencent/ecommerce/biz/router/a;", "filterProvider", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f450402c = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static HashMap<String, IECRouterLauncher> routerMap = new HashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.ecommerce.biz.router.a filterProvider = new com.tencent.ecommerce.biz.router.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J0\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"yi0/a$a", "Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "Landroid/content/Context;", "packageContext", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "cls", "Landroid/os/Bundle;", "bundle", "", "launch", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "launchForResult", "Landroid/content/Intent;", "getIntent", "launchFragmentClz", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: yi0.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11616a implements IECRouterLauncher {
        C11616a() {
        }

        @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
        public Intent getIntent(Context packageContext, Class<? extends Fragment> cls, Bundle bundle) {
            boolean e16 = a.f450402c.e(bundle);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            return com.tencent.ecommerce.base.plugin.a.f100882a.a(packageContext, intent, cls, e16);
        }

        @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
        public boolean launch(Context packageContext, Class<? extends Fragment> cls, Bundle bundle) {
            boolean e16 = a.f450402c.e(bundle);
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtras(bundle);
            com.tencent.ecommerce.base.plugin.a.f100882a.c(intent, cls, e16);
            return true;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
        public boolean launchForResult(Activity activity, int requestCode, Class<? extends Fragment> cls, Bundle bundle) {
            boolean e16 = a.f450402c.e(bundle);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            com.tencent.ecommerce.base.plugin.a.f100882a.d(activity, intent, cls, requestCode, e16);
            return true;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
        public Class<? extends Fragment> launchFragmentClz() {
            return null;
        }
    }

    a() {
    }

    private final IECRouterLauncher b() {
        boolean b16 = b.f103963a.b();
        cg0.a.b("ECRouter", "getRegisterRouterLauncher isNewRegisterSwitchOn = " + b16 + TokenParser.SP);
        if (b16) {
            return new xi0.a(ECommerceRegisterIntroFragment.class);
        }
        return new xi0.a(ECommerceRegisterIntroFragment.class);
    }

    private final IECRouterLauncher c(Uri uri, Map<String, String> params) {
        String joinToString$default;
        String g16 = g(uri);
        IECRouterLauncher iECRouterLauncher = routerMap.get(g16);
        if ((iECRouterLauncher != null ? iECRouterLauncher.launchFragmentClz() : null) == null) {
            iECRouterLauncher = h(params);
        }
        if ((iECRouterLauncher != null ? iECRouterLauncher.launchFragmentClz() : null) == null) {
            iECRouterLauncher = routerMap.get(j(uri));
        }
        if ((iECRouterLauncher != null ? iECRouterLauncher.launchFragmentClz() : null) == null) {
            iECRouterLauncher = routerMap.get(i(uri));
        }
        if ((iECRouterLauncher != null ? iECRouterLauncher.launchFragmentClz() : null) == null) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(routerMap.keySet(), ", ", null, null, 0, null, null, 62, null);
            cg0.a.a("ECRouter", "getRouterLauncher", "routerKey=" + g16 + ", keys=" + joinToString$default);
        }
        return iECRouterLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(Bundle bundle) {
        boolean areEqual = Intrinsics.areEqual(bundle.getString("is_trans_activity"), "1");
        return !areEqual ? Intrinsics.areEqual(bundle.getString(KuiklyLaunchParams.PARAM_MODAL_MODE), "1") : areEqual;
    }

    private final String g(Uri uri) {
        String str;
        String str2;
        String str3 = "*";
        if (uri.getScheme() == null) {
            str = "*";
        } else {
            str = uri.getScheme();
        }
        if (uri.getHost() == null) {
            str2 = "*";
        } else {
            str2 = uri.getHost();
        }
        if (uri.getPath() != null) {
            str3 = uri.getPath();
        }
        return str + util.base64_pad_url + str2 + util.base64_pad_url + str3;
    }

    private final String i(Uri uri) {
        String str = l(uri).get("target");
        if (str == null) {
            str = 0;
        }
        return "*_*_" + str;
    }

    private final String j(Uri uri) {
        String str;
        if (uri.getScheme() != null) {
            str = uri.getScheme();
        } else {
            str = "*";
        }
        return Intrinsics.stringPlus(str, "_*_*");
    }

    private final Bundle k(Uri uri, Map<String, String> params) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : l(uri).entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        if (params != null) {
            for (Map.Entry<String, String> entry2 : params.entrySet()) {
                bundle.putString(entry2.getKey(), entry2.getValue());
            }
        }
        return bundle;
    }

    private final void n() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerGlobalLauncher proxy=");
        a.Companion companion = xi0.a.INSTANCE;
        sb5.append(companion.a());
        cg0.a.b("ECRouter", sb5.toString());
        if (companion.a() == null) {
            companion.b(new C11616a());
        }
    }

    @JvmStatic
    public static final void o(Map<Integer, ? extends IECRouterLauncher> router) {
        Iterator<Integer> it = router.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            String g16 = f450402c.g(Uri.parse(String.valueOf(intValue)));
            IECRouterLauncher iECRouterLauncher = router.get(Integer.valueOf(intValue));
            if (iECRouterLauncher != null) {
                routerMap.put(g16, iECRouterLauncher);
            }
        }
    }

    @JvmStatic
    public static final void p(Context context, Class<? extends ECBaseFragment> fragment, Bundle bundle, int requestCode, IECSchemeCallback callback) {
        xi0.a aVar = new xi0.a(fragment);
        Map<String, String> c16 = ug0.a.c(callback);
        if (!c16.isEmpty()) {
            for (Map.Entry<String, String> entry : c16.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        if (context instanceof Activity) {
            aVar.launchForResult((Activity) context, requestCode, fragment, bundle);
        } else {
            aVar.launch(context, fragment, bundle);
        }
    }

    @JvmStatic
    public static final boolean s(Uri uri, Map<String, String> params, Map<Object, ? extends Object> extUserData, IECSchemeCallback callback) {
        if (uri == null) {
            cg0.a.a("ECRouter", "routerURL", "router url invalid!");
            return false;
        }
        a aVar = f450402c;
        IECRouterLauncher c16 = aVar.c(uri, params);
        if (!aVar.f(c16)) {
            cg0.a.a("ECRouter", "routerURL", c16 + " class invalid");
            return false;
        }
        Bundle k3 = aVar.k(uri, params);
        if (extUserData != null) {
            k3.putSerializable("ext_userdata", new ECSchemeExtUserDataMap(extUserData));
        }
        Application a16 = wg0.a.a();
        Class<? extends Fragment> launchFragmentClz = c16 != null ? c16.launchFragmentClz() : null;
        if (launchFragmentClz == null) {
            cg0.a.b("ECRouter", "will handle route " + c16 + " topContext or topActivity invalid!");
            return false;
        }
        Map<String, String> c17 = ug0.a.c(callback);
        if (!c17.isEmpty()) {
            for (Map.Entry<String, String> entry : c17.entrySet()) {
                k3.putString(entry.getKey(), entry.getValue());
            }
        }
        cg0.a.b("ECRouter", "will handle route " + c16 + " bundle:" + k3);
        List<IECRouterFilter> list = filterProvider.get();
        if (!list.isEmpty()) {
            for (IECRouterFilter iECRouterFilter : list) {
                if (iECRouterFilter.accept(launchFragmentClz)) {
                    return iECRouterFilter.filterLaunch(c16, a16, launchFragmentClz, k3);
                }
            }
        }
        return c16.launch(a16, launchFragmentClz, k3);
    }

    @JvmStatic
    public static final boolean u(Activity activity, int requestCode, Uri uri, Map<String, String> params) {
        a aVar = f450402c;
        IECRouterLauncher c16 = aVar.c(uri, params);
        if (!aVar.f(c16)) {
            cg0.a.a("ECRouter", "routerUrlForResult", c16 + " class invalid");
            return false;
        }
        Bundle k3 = aVar.k(uri, params);
        cg0.a.b("ECRouter", "will handle route " + c16 + " bundle:" + k3);
        Class<? extends Fragment> launchFragmentClz = c16 != null ? c16.launchFragmentClz() : null;
        if (launchFragmentClz == null) {
            cg0.a.a("ECRouter", "routerUrlForResult", "will handle route " + c16 + " topContext or topActivity invalid!");
            return false;
        }
        List<IECRouterFilter> list = filterProvider.get();
        if (!list.isEmpty()) {
            for (IECRouterFilter iECRouterFilter : list) {
                if (iECRouterFilter.accept(launchFragmentClz)) {
                    return iECRouterFilter.filterLaunchForResult(c16, activity, requestCode, launchFragmentClz, k3);
                }
            }
        }
        return c16.launchForResult(activity, requestCode, launchFragmentClz, k3);
    }

    @JvmStatic
    public static final boolean v(Uri uri, Map<String, String> params) {
        a aVar = f450402c;
        return aVar.f(aVar.c(uri, params));
    }

    public final void d() {
        n();
        m();
    }

    public final Map<String, String> l(Uri uri) {
        Object last;
        HashMap hashMap = new HashMap();
        try {
            for (String str : uri.getQueryParameterNames()) {
                List<String> queryParameters = uri.getQueryParameters(str);
                if (!queryParameters.isEmpty()) {
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) queryParameters);
                    hashMap.put(str, last);
                } else {
                    hashMap.put(str, "");
                }
            }
        } catch (Exception unused) {
            cg0.a.a("ECRouter", "queryUriParameter", "uri.queryParameterNames or uri.getQueryParameters failed.");
        }
        return hashMap;
    }

    private final boolean f(IECRouterLauncher launcher) {
        if (launcher == null) {
            cg0.a.a("ECRouter", "isValidClz", "the launcher invalid");
            return false;
        }
        if (launcher.launchFragmentClz() == null) {
            cg0.a.a("ECRouter", "isValidClz", "the launcher fragment class invalid");
            return false;
        }
        return launcher.launchFragmentClz() instanceof Class;
    }

    private final IECRouterLauncher h(Map<String, String> arguments) {
        if (arguments == null) {
            cg0.a.b("ECRouter", "[parseRouterKeyWithSpecialTarget] argument is null!");
            return null;
        }
        String str = arguments.get("target");
        if (str == null) {
            return null;
        }
        if (!Intrinsics.areEqual(str, String.valueOf(9))) {
            cg0.a.b("ECRouter", "[parseRouterKeyWithSpecialTarget] target =" + str + ", is not product detail target");
            return null;
        }
        cg0.a.b("ECRouter", "[parseRouterKeyWithSpecialTarget] target =" + str + ", arguments = " + arguments);
        String str2 = arguments.get("is_host");
        if (str2 == null) {
            str2 = "0";
        }
        String str3 = arguments.get("biz_type");
        if (str3 == null) {
            str3 = "";
        }
        if (e.f102467a.f(str3)) {
            String str4 = arguments.get("is_off_sale");
            if (str4 == null) {
                str4 = "0";
            }
            if (Intrinsics.areEqual(str4, "1")) {
                return new xi0.a(ECShopProductDetailOffSaleFragment.class);
            }
            String str5 = arguments.get("is_distributor");
            if (Intrinsics.areEqual(str5 != null ? str5 : "0", "1")) {
                return new xi0.a(ECShopDetailDistributionFragment.class);
            }
            return new xi0.a(ECShopProductDetailPageFragment.class);
        }
        if (Intrinsics.areEqual(str2, "1")) {
            return new xi0.a(ECDetailHostPageFragment.class);
        }
        return new xi0.a(ECDetailCustomPageFragment.class);
    }

    @JvmStatic
    public static final boolean r(Uri uri) {
        return s(uri, null, null, null);
    }

    private final void m() {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(10000, new xi0.a(ECMainPageFragment.class)), TuplesKt.to(2, new xi0.a(ECOrderListContainerFragment.class)), TuplesKt.to(3, new xi0.a(ECBuyerOrderCommentFragment.class)), TuplesKt.to(4, new xi0.a(ECCommissionDetailFragment.class)), TuplesKt.to(5, new xi0.a(ECGoodsCenterFragment.class)), TuplesKt.to(1, b()), TuplesKt.to(6, new xi0.a(ECSellerOrderContainerFragment.class)), TuplesKt.to(7, new xi0.a(ECShowWindowFragment.class)), TuplesKt.to(35, new xi0.a(ECProductCardEditorFragment.class)), TuplesKt.to(8, new xi0.a(ECShowWindowSearchFragment.class)), TuplesKt.to(10, new xi0.a(ECSelectProductFragment.class)), TuplesKt.to(12, new xi0.a(ECTransactionDataFragment.class)), TuplesKt.to(11, new xi0.a(ECCommissionOverviewFragment.class)), TuplesKt.to(15, new xi0.a(ECSellerOrderSearchFragment.class)), TuplesKt.to(16, new xi0.a(ECBuyerOrderSearchFragment.class)), TuplesKt.to(17, new xi0.a(ECBaseHippyFragment.class)), TuplesKt.to(19, new xi0.a(ECLiveWindowMainFragment.class)), TuplesKt.to(25, new xi0.a(ECLiveGameSelectGoodsTypeFragment.class)), TuplesKt.to(29, new xi0.a(ECCommissionForecastDetailListFragment.class)), TuplesKt.to(21, new xi0.a(ECShopHomeFragment.class)), TuplesKt.to(27, new xi0.a(ECEditAddressFragment.class)), TuplesKt.to(26, new xi0.a(ECShopHomeSecondProductListFragment.class)), TuplesKt.to(28, new xi0.a(ECAddressManagerFragment.class)), TuplesKt.to(32, new xi0.a(ECShopHomeQualificationFragment.class)), TuplesKt.to(30, new xi0.a(ECShopHomeSearchFragment.class)), TuplesKt.to(33, new xi0.a(ECShopProductDetailSkuInfoFragment.class)), TuplesKt.to(22, new xi0.a(ECOrderSubmitLauncherFragment.class)), TuplesKt.to(24, new xi0.a(ECShopOrderDetailFragment.class)), TuplesKt.to(31, new xi0.a(ECShopHomeSearchResultFragment.class)), TuplesKt.to(34, new xi0.a(ECAddressPickerFragment.class)), TuplesKt.to(36, new xi0.a(ECAfterSaleApplyFragment.class)), TuplesKt.to(38, new xi0.a(ECHRFragment.class)), TuplesKt.to(39, new xi0.a(ECShopProductCommentPageFragment.class)), TuplesKt.to(29, new xi0.a(ECCommissionForecastDetailListFragment.class)), TuplesKt.to(43, new xi0.a(ECCustomerServiceFragment.class)), TuplesKt.to(45, new xi0.a(ECQShopPromoteListFragment.class)), TuplesKt.to(41, new xi0.a(ECSubmitLogisticsFragment.class)), TuplesKt.to(40, new xi0.a(ECConsultHistoryFragment.class)), TuplesKt.to(47, new xi0.a(ECommerceRegisterUserInfoFragment.class)), TuplesKt.to(48, new xi0.a(ECommerceRegisterAgreementFragment.class)), TuplesKt.to(50, new xi0.a(ECommerceRegisterAuthorizeFragment.class)), TuplesKt.to(46, new xi0.a(ECQGroupWindowFragment.class)), TuplesKt.to(49, new xi0.a(ECLogisticsTraceFragment.class)), TuplesKt.to(51, new xi0.a(ECLiveQShopShowWindowFragment.class)), TuplesKt.to(52, new xi0.a(ECHRFragment.class)), TuplesKt.to(53, new xi0.a(ECSampleOrderDetailFragment.class)), TuplesKt.to(54, new xi0.a(ECPromotionFloatWindow.class)), TuplesKt.to(56, new xi0.a(ECommerceSettleAuthenticationFragment.class)), TuplesKt.to(55, new xi0.a(ECMyShoppingActionSheetFragment.class)), TuplesKt.to(57, new xi0.a(ECSelectProductSearchFragment.class)), TuplesKt.to(58, new xi0.a(ECFloatCommonDetailBulletinFragment.class)), TuplesKt.to(59, zh0.b.f452542a));
        o(mapOf);
    }

    public static /* synthetic */ void q(Context context, Class cls, Bundle bundle, int i3, IECSchemeCallback iECSchemeCallback, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            bundle = new Bundle();
        }
        if ((i16 & 8) != 0) {
            i3 = 0;
        }
        if ((i16 & 16) != 0) {
            iECSchemeCallback = null;
        }
        p(context, cls, bundle, i3, iECSchemeCallback);
    }

    public static /* synthetic */ boolean t(Uri uri, Map map, Map map2, IECSchemeCallback iECSchemeCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map2 = null;
        }
        if ((i3 & 8) != 0) {
            iECSchemeCallback = null;
        }
        return s(uri, map, map2, iECSchemeCallback);
    }
}
