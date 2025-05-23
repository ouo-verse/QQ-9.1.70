package z74;

import android.content.res.AssetManager;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartGoodsData;
import com.tencent.sqshow.zootopia.nativeui.data.cart.PriceType;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.e;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import d94.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import t74.m;
import uv4.bc;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00015B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\tR\u001c\u0010\u0019\u001a\n \u0013*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\n \u0013*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\n \u0013*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\tR\u001c\u0010!\u001a\n \u0013*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u001c\u0010%\u001a\n \u0013*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010'\u001a\n \u0013*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\tR\u001c\u0010)\u001a\n \u0013*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001cR\u001c\u0010+\u001a\n \u0013*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u001cR\u001c\u0010-\u001a\n \u0013*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\u0018R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lz74/c;", "Ld94/h$a;", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", "data", "", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "t", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "G", "Ljava/util/List;", "getMData", "()Ljava/util/List;", "mData", "kotlin.jvm.PlatformType", "H", "goodsCurrencyContainer", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "currencyText", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "currencyIcon", "K", "goodsContainer", "L", "goodsName", "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "M", "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "goodsImageView", "N", "goodsCounter", "P", "goodsCounterPlus", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "goodsCounterMinus", BdhLogUtil.LogTag.Tag_Req, "goodsCountNum", "Landroid/os/CountDownTimer;", ExifInterface.LATITUDE_SOUTH, "Landroid/os/CountDownTimer;", "campaignBeginTimer", "<init>", "(Landroid/view/View;Ljava/util/List;)V", "T", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends h.a {

    /* renamed from: F, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    private final List<CartGoodsData> mData;

    /* renamed from: H, reason: from kotlin metadata */
    private final View goodsCurrencyContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView currencyText;

    /* renamed from: J, reason: from kotlin metadata */
    private final ImageView currencyIcon;

    /* renamed from: K, reason: from kotlin metadata */
    private final View goodsContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private final TextView goodsName;

    /* renamed from: M, reason: from kotlin metadata */
    private final RoundCornerImageView goodsImageView;

    /* renamed from: N, reason: from kotlin metadata */
    private final View goodsCounter;

    /* renamed from: P, reason: from kotlin metadata */
    private final ImageView goodsCounterPlus;

    /* renamed from: Q, reason: from kotlin metadata */
    private final ImageView goodsCounterMinus;

    /* renamed from: R, reason: from kotlin metadata */
    private final TextView goodsCountNum;

    /* renamed from: S, reason: from kotlin metadata */
    private CountDownTimer campaignBeginTimer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"z74/c$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v3) {
            QLog.d("ShoppingCartListAdapter", 1, " View detached~");
            CountDownTimer countDownTimer = c.this.campaignBeginTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            c.this.getRootView().removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v3) {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: z74.c$c, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public /* synthetic */ class C11662c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f452132a;

        static {
            int[] iArr = new int[PriceType.values().length];
            try {
                iArr[PriceType.GOAL_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PriceType.SILVER_FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PriceType.GOAL_AND_SILVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f452132a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View rootView, List<CartGoodsData> list) {
        super(rootView);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.rootView = rootView;
        this.mData = list;
        this.goodsCurrencyContainer = rootView.findViewById(R.id.pxj);
        TextView textView = (TextView) rootView.findViewById(R.id.pnj);
        this.currencyText = textView;
        this.currencyIcon = (ImageView) rootView.findViewById(R.id.pnh);
        View findViewById = rootView.findViewById(R.id.pxe);
        this.goodsContainer = findViewById;
        this.goodsName = (TextView) rootView.findViewById(R.id.pxo);
        this.goodsImageView = (RoundCornerImageView) findViewById.findViewById(R.id.pxl);
        View findViewById2 = rootView.findViewById(R.id.pxg);
        this.goodsCounter = findViewById2;
        this.goodsCounterPlus = (ImageView) findViewById2.findViewById(R.id.pxi);
        this.goodsCounterMinus = (ImageView) findViewById2.findViewById(R.id.pxh);
        this.goodsCountNum = (TextView) findViewById2.findViewById(R.id.pxf);
        m mVar = m.f435564a;
        AssetManager assets = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        textView.setTypeface(mVar.b(assets));
        rootView.addOnAttachStateChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(c this$0, CartGoodsData data, View view) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(this$0.goodsCountNum.getText().toString());
        if (intOrNull != null) {
            int intValue = intOrNull.intValue() - 1;
            if (intValue < 1) {
                QLog.i("GoodsWithCounterViewHolder", 1, "counter num is 1, cannot minus.");
                return;
            }
            this$0.goodsCountNum.setText(String.valueOf(intValue));
            data.g(intValue);
            List<CartGoodsData> list = this$0.mData;
            if (list != null) {
                com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.I(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(c this$0, CartGoodsData data, View view) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(this$0.goodsCountNum.getText().toString());
        if (intOrNull != null) {
            int intValue = intOrNull.intValue() + 1;
            if (intValue > 50) {
                QLog.i("GoodsWithCounterViewHolder", 1, "counter num is 50, cannot plus.");
                return;
            }
            this$0.goodsCountNum.setText(String.valueOf(intValue));
            data.g(intValue);
            List<CartGoodsData> list = this$0.mData;
            if (list != null) {
                com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.I(list);
            }
        }
    }

    private final void u(CartGoodsData data) {
        this.goodsName.setText(data.getItemData().f440277d);
        int i3 = C11662c.f452132a[data.getPriceType().ordinal()];
        if (i3 == 1) {
            this.currencyIcon.setImageResource(R.drawable.ilx);
            TextView textView = this.currencyText;
            e eVar = e.f373267a;
            bc bcVar = data.getItemData().f440287n;
            textView.setText(eVar.a(bcVar != null ? bcVar.f440315d : 0));
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            QLog.e("ShoppingCartListAdapter", 1, "wrong type");
        } else {
            this.currencyIcon.setImageResource(R.drawable.f159901im2);
            TextView textView2 = this.currencyText;
            e eVar2 = e.f373267a;
            bc bcVar2 = data.getItemData().f440287n;
            textView2.setText(eVar2.a(bcVar2 != null ? bcVar2.f440316e : 0));
        }
    }

    public final void q(final CartGoodsData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("GoodsWithCounterViewHolder", 1, "bindData => " + data.getItemData().f440275b + " ==> [ " + data.getItemData().f440277d + " ], " + data.getIsSelected() + " ," + data.getPriceType() + " \n");
        String str = data.getItemData().f440279f;
        if (str != null) {
            RoundCornerImageView goodsImageView = this.goodsImageView;
            Intrinsics.checkNotNullExpressionValue(goodsImageView, "goodsImageView");
            CommonExKt.w(goodsImageView, str, q.b(R.drawable.h4b), null, 4, null);
        }
        u(data);
        this.goodsCounterMinus.setOnClickListener(new View.OnClickListener() { // from class: z74.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.r(c.this, data, view);
            }
        });
        this.goodsCounterPlus.setOnClickListener(new View.OnClickListener() { // from class: z74.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.s(c.this, data, view);
            }
        });
    }

    /* renamed from: t, reason: from getter */
    public final View getRootView() {
        return this.rootView;
    }
}
