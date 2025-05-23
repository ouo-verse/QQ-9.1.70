package ub0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001,B\u000f\u0012\u0006\u0010)\u001a\u00020\u0011\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u000f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010#R\u001c\u0010(\u001a\n %*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lub0/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "", "uinType", "", "labelText", "", "t", "Lcom/tencent/biz/qqcircle/comment/at/bean/QFSCommentAtEntity;", "entity", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lo20/a;", "itemInfo", com.tencent.luggage.wxa.c8.c.G, "o", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "label", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "avatar", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "G", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "H", "Lo20/a;", "userItem", "I", "Landroid/util/Size;", "kotlin.jvm.PlatformType", "J", "Landroid/util/Size;", "avatarSize", "itemView", "<init>", "(Landroid/view/View;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class d extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TextView label;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private QCircleAvatarView avatar;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private QUICheckBox checkbox;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private o20.a userItem;

    /* renamed from: I, reason: from kotlin metadata */
    private int pos;

    /* renamed from: J, reason: from kotlin metadata */
    private final Size avatarSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lub0/d$a;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "Lcom/tencent/biz/qqcircle/comment/at/bean/QFSCommentAtEntity;", "entity", "", "b", "event", "a", ReportConstant.COSTREPORT_PREFIX, "", "", "getDynamicParams", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lub0/d;", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "mWrfItemVH", "itemVH", "<init>", "(Lub0/d;Lub0/d;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public final class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.avatar.meta.refresh.c<d> mWrfItemVH;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f438757b;

        public a(@NotNull d dVar, d itemVH) {
            Intrinsics.checkNotNullParameter(itemVH, "itemVH");
            this.f438757b = dVar;
            this.mWrfItemVH = new com.tencent.qqnt.avatar.meta.refresh.c<>(itemVH);
        }

        private final String a(String event) {
            boolean z16;
            o20.a aVar = this.f438757b.userItem;
            if (aVar != null) {
                z16 = aVar.b();
            } else {
                z16 = false;
            }
            if (TextUtils.equals(event, "clck")) {
                z16 = !z16;
            }
            if (z16) {
                return "1";
            }
            return "0";
        }

        private final String b(QFSCommentAtEntity entity) {
            if (entity == null) {
                return "";
            }
            return ua0.d.f(entity.f()) + entity.e();
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String s16) {
            QFSCommentAtEntity qFSCommentAtEntity;
            Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
            d dVar = this.mWrfItemVH.get();
            if (dVar != null) {
                Intrinsics.checkNotNullExpressionValue(params, "params");
                o20.a aVar = dVar.userItem;
                if (aVar != null) {
                    qFSCommentAtEntity = aVar.a();
                } else {
                    qFSCommentAtEntity = null;
                }
                params.put("xsj_target_qq", b(qFSCommentAtEntity));
                params.put("xsj_is_tick", a(s16));
            }
            Intrinsics.checkNotNullExpressionValue(params, "params");
            return params;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.f56962m1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.qfs_user_nick)");
        this.label = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f56892lu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.qfs_user_avatar)");
        this.avatar = (QCircleAvatarView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f3484109);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.qfs_check_box)");
        this.checkbox = (QUICheckBox) findViewById3;
        this.pos = -1;
        this.avatarSize = n.a(itemView.getContext(), R.dimen.d0e);
        this.avatar.i();
        this.checkbox.setType(3);
        this.checkbox.setChecked(false);
        this.checkbox.setClickable(false);
        itemView.setOnClickListener(this);
    }

    private final void p() {
        VideoReport.setElementId(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_RECENTLY_SHARE);
        VideoReport.setEventDynamicParams(this.itemView, new a(this, this));
        VideoReport.setElementExposePolicy(this.itemView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.itemView, ClickPolicy.REPORT_ALL);
    }

    private final void q(QFSCommentAtEntity entity) {
        if (entity.f() == 1) {
            QFSCommentAtHelper.t0(entity.e(), entity.f(), this.avatar);
        } else {
            this.avatar.k().setImageDrawable(QCirclePluginGlobalInfo.s(entity.e(), new QCircleFaceBitmapListener() { // from class: ub0.c
                @Override // com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener
                public final void getFaceBitmap(Bitmap bitmap) {
                    d.r(d.this, bitmap);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(d this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bitmap != null) {
            this$0.avatar.k().setImageDrawable(new BitmapDrawable(this$0.itemView.getContext().getResources(), bitmap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(QFSCommentAtEntity entity, d this$0, boolean z16, wb0.d dVar) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dVar.l4(entity, this$0.pos, !z16);
    }

    private final void t(int uinType, String labelText) {
        Resources resources = this.itemView.getContext().getResources();
        if (uinType == 10008) {
            String qqStr = HardCodeUtil.qqStr(R.string.o29);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_messagef_da17cdf9)");
            SpannableString spannableString = new SpannableString(qqStr + labelText);
            spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R.color.cbr, null)), 0, qqStr.length(), 33);
            this.label.setText(spannableString);
            return;
        }
        this.label.setText(labelText);
    }

    public final void o(@NotNull o20.a itemInfo, int pos) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        this.userItem = itemInfo;
        this.pos = pos;
        QFSCommentAtEntity entity = itemInfo.a();
        int f16 = entity.f();
        String b16 = entity.b();
        Intrinsics.checkNotNullExpressionValue(b16, "entity.getName()");
        t(f16, b16);
        this.checkbox.setChecked(itemInfo.b());
        Intrinsics.checkNotNullExpressionValue(entity, "entity");
        q(entity);
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        final QFSCommentAtEntity qFSCommentAtEntity;
        final boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            o20.a aVar = this.userItem;
            if (aVar != null) {
                qFSCommentAtEntity = aVar.a();
            } else {
                qFSCommentAtEntity = null;
            }
            if (qFSCommentAtEntity != null) {
                o20.a aVar2 = this.userItem;
                if (aVar2 != null) {
                    z16 = aVar2.b();
                } else {
                    z16 = false;
                }
                RFWIocAbilityProvider.g().getIoc(wb0.d.class).originView(this.itemView).done(new OnPromiseResolved() { // from class: ub0.b
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj) {
                        d.s(QFSCommentAtEntity.this, this, z16, (wb0.d) obj);
                    }
                }).run();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
