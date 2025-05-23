package q14;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfo;
import com.tencent.robot.adelie.homepage.cards.tool.AdelieHomeToolCardItem;
import com.tencent.robot.adelie.homepage.category.viewmodel.ToolDelegateData;
import com.tencent.robot.adelie.homepage.utils.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u64.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J*\u0010\u001e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u00072\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001cH\u0014J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0010H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001e\u00109\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R&\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u000b0:j\b\u0012\u0004\u0012\u00020\u000b`;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lq14/c;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/h;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "", "index", "", "subjectName", "Lcom/tencent/robot/adelie/homepage/cards/tool/AdelieHomeToolCardItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "t", HippyTKDListViewAdapter.X, "", ReportConstant.COSTREPORT_PREFIX, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "", "r", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "position", "", "payload", "y", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "attached", "onAttachedChanged", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "toolTopBar", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "moreImageView", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "toolCardContainer", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "toolTitle", "i", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/h;", "toolData", "Lmqq/util/WeakReference;", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmqq/util/WeakReference;", "weakContent", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "childList", "<init>", "()V", "D", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends Section<ToolDelegateData> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<AdelieHomeToolCardItem> childList = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout toolTopBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView moreImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout toolCardContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView toolTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ToolDelegateData toolData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Context> weakContent;

    private final void A() {
        Context context;
        WeakReference<Context> weakReference = this.weakContent;
        if (weakReference != null && (context = weakReference.get()) != null) {
            Drawable o16 = ie0.a.f().o(context, R.drawable.qui_chevron_right, R.color.qui_common_icon_primary, 1000);
            ImageView imageView = this.moreImageView;
            if (imageView != null) {
                imageView.setImageDrawable(o16);
            }
        }
    }

    private final AdelieHomeToolCardItem q(int index, String subjectName) {
        Context context;
        if (index < this.childList.size()) {
            return this.childList.get(index);
        }
        WeakReference<Context> weakReference = this.weakContent;
        if (weakReference != null && (context = weakReference.get()) != null) {
            AdelieHomeToolCardItem adelieHomeToolCardItem = new AdelieHomeToolCardItem(context, null, 0, subjectName);
            FontSettingManager.resetViewSize2Normal(adelieHomeToolCardItem.getContext(), adelieHomeToolCardItem);
            this.childList.add(adelieHomeToolCardItem);
        }
        if (index >= this.childList.size()) {
            return null;
        }
        return this.childList.get(index);
    }

    private final Map<String, Object> r() {
        CharSequence charSequence;
        Map<String, Object> mapOf;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("dt_pgid", "pg_bas_agent_home_page_new");
        TextView textView = this.toolTitle;
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        pairArr[1] = TuplesKt.to("subject_name", charSequence);
        pairArr[2] = TuplesKt.to(IPublicAccountConfigAttr.CARD_STYLE, 3);
        pairArr[3] = TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_theme_card");
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final boolean s() {
        if (x().length() > 0) {
            return true;
        }
        return false;
    }

    private final void t() {
        VideoReport.setElementId(getRootView(), "em_bas_theme_card");
        View rootView = getRootView();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(rootView, clickPolicy);
        RelativeLayout relativeLayout = this.toolTopBar;
        if (relativeLayout != null) {
            VideoReport.setElementId(relativeLayout, "em_bas_top_right_arrow");
            VideoReport.setElementClickPolicy(relativeLayout, clickPolicy);
        }
    }

    private final void u() {
        RelativeLayout relativeLayout = this.toolTopBar;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: q14.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.v(c.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(c this$0, View view) {
        boolean z16;
        WeakReference<Context> weakReference;
        Context cxt;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!g.f438512a.g()) {
            if (this$0.x().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (weakReference = this$0.weakContent) != null && (cxt = weakReference.get()) != null) {
                n nVar = n.f366680a;
                Intrinsics.checkNotNullExpressionValue(cxt, "cxt");
                nVar.f(cxt, this$0.x());
            }
            VideoReport.reportEvent("clck", this$0.toolTopBar, this$0.r());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w(ToolDelegateData data) {
        LinearLayout linearLayout = this.toolCardContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        if (data.getCard().robots.isEmpty()) {
            return;
        }
        ViewUtils.f352270a.a(81.0f);
        ArrayList<RobotCoreInfo> arrayList = data.getCard().robots;
        Intrinsics.checkNotNullExpressionValue(arrayList, "data.card.robots");
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RobotCoreInfo item = (RobotCoreInfo) obj;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            String str = data.getCard().name;
            Intrinsics.checkNotNullExpressionValue(str, "data.card.name");
            AdelieHomeToolCardItem q16 = q(i3, str);
            if (q16 != null) {
                Intrinsics.checkNotNullExpressionValue(item, "item");
                q16.setData(item);
                LinearLayout linearLayout2 = this.toolCardContainer;
                if (linearLayout2 != null) {
                    linearLayout2.addView(q16, layoutParams);
                }
            }
            i3 = i16;
        }
    }

    private final String x() {
        String str;
        RobotRecommendCardInfo card;
        ToolDelegateData toolDelegateData = this.toolData;
        if (toolDelegateData != null && (card = toolDelegateData.getCard()) != null) {
            str = card.jumpUrl;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void z(ToolDelegateData data) {
        this.toolData = data;
        TextView textView = this.toolTitle;
        if (textView != null) {
            textView.setText(data.getCard().name);
        }
        if (!s()) {
            ImageView imageView = this.moreImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.toolTopBar;
            if (relativeLayout != null) {
                VideoReport.reportEvent("imp", relativeLayout, r());
            }
        }
        if (this.toolCardContainer != null) {
            w(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        if (attached) {
            VideoReport.reportEvent("imp", getRootView(), r());
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        this.weakContent = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        ImageView imageView;
        Context context;
        if (containerView != null && (context = containerView.getContext()) != null) {
            this.weakContent = new WeakReference<>(context);
            FontSettingManager.resetViewSize2Normal(context, containerView);
        }
        TextView textView = null;
        if (containerView != null) {
            relativeLayout = (RelativeLayout) containerView.findViewById(R.id.f779245o);
        } else {
            relativeLayout = null;
        }
        this.toolTopBar = relativeLayout;
        if (containerView != null) {
            linearLayout = (LinearLayout) containerView.findViewById(R.id.f777845a);
        } else {
            linearLayout = null;
        }
        this.toolCardContainer = linearLayout;
        if (containerView != null) {
            imageView = (ImageView) containerView.findViewById(R.id.f06);
        } else {
            imageView = null;
        }
        this.moreImageView = imageView;
        if (containerView != null) {
            textView = (TextView) containerView.findViewById(R.id.f779145n);
        }
        this.toolTitle = textView;
        u();
        A();
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable ToolDelegateData data, int position, @Nullable List<Object> payload) {
        if (data != null) {
            z(data);
        }
    }
}
