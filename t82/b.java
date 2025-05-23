package t82;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.widget.QQKLAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b@\u0010AJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tJ \u0010\u0011\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0017\u00107\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R*\u0010=\u001a\u00020\t2\u0006\u00108\u001a\u00020\t8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00104\u001a\u0004\b:\u00106\"\u0004\b;\u0010<R\u0011\u0010?\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b>\u00106\u00a8\u0006B"}, d2 = {"Lt82/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lt82/c;", "Landroid/view/View;", "view", "", "isZplanAvatar", "", "q0", "", "position", "k0", "", "j0", "", "avatarList", "userZplanAvatarUrl", "r0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "p0", "holder", "n0", "getItemCount", "Lt82/d;", "listener", "s0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "D", "Lt82/d;", "getListener", "()Lt82/d;", "setListener", "(Lt82/d;)V", "E", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", UserInfo.SEX_FEMALE, "Z", "containsUserZplanAvatar", "G", "I", "l0", "()I", "scaleViewId", "value", "H", "getRandom", "t0", "(I)V", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "m0", "selectedAvatarWidth", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends RecyclerView.Adapter<c> {

    /* renamed from: C, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private d listener;

    /* renamed from: E, reason: from kotlin metadata */
    private List<String> data;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean containsUserZplanAvatar;

    /* renamed from: G, reason: from kotlin metadata */
    private final int scaleViewId;

    /* renamed from: H, reason: from kotlin metadata */
    private int random;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    public b(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.rootView = view;
        this.data = new ArrayList();
        this.scaleViewId = View.generateViewId();
    }

    private final int k0(int position) {
        if (this.data.size() == 0) {
            return 0;
        }
        int size = (position - 1073741824) % this.data.size();
        return size < 0 ? size + this.data.size() : size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(b this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d dVar = this$0.listener;
        if (dVar != null) {
            dVar.onClick(i3);
        }
    }

    private final void q0(View view, boolean isZplanAvatar) {
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_is_avatar", Integer.valueOf(isZplanAvatar ? 1 : 0));
        y82.a.b().g(view, "em_bas_avatar", hashMap);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return Integer.MAX_VALUE;
    }

    public final String j0(int position) {
        int k06;
        if (position < 0 || this.data.isEmpty() || (k06 = k0(position)) >= this.data.size()) {
            return "";
        }
        return this.data.get(k06);
    }

    /* renamed from: l0, reason: from getter */
    public final int getScaleViewId() {
        return this.scaleViewId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.data.isEmpty()) {
            return;
        }
        holder.getContent().setId(this.scaleViewId);
        holder.getContent().setAlpha(0.6f);
        int k06 = k0(position);
        if (k06 < this.data.size()) {
            QQKLAvatarView.d(holder.getAvatarView(), this.data.get(k06), null, 2, null);
        }
        holder.getAvatarView().setOnClickListener(new View.OnClickListener() { // from class: t82.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.o0(b.this, position, view);
            }
        });
        boolean e16 = com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a.e(this.data.get(k06));
        holder.getZplanTipsView().setVisibility(e16 ? 0 : 8);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        q0(view, e16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View container = LayoutInflater.from(this.context).inflate(R.layout.cwa, parent, false);
        View contentView = container.findViewById(R.id.oji);
        QQKLAvatarView avatarView = (QQKLAvatarView) container.findViewById(R.id.oi5);
        View zplanTipsView = container.findViewById(R.id.osu);
        View view = this.rootView;
        if (view != null) {
            VideoReport.setLogicParent(container, view);
        }
        Intrinsics.checkNotNullExpressionValue(container, "container");
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        Intrinsics.checkNotNullExpressionValue(avatarView, "avatarView");
        Intrinsics.checkNotNullExpressionValue(zplanTipsView, "zplanTipsView");
        return new c(container, contentView, avatarView, zplanTipsView);
    }

    public final void r0(List<String> avatarList, String userZplanAvatarUrl) {
        boolean z16;
        Intrinsics.checkNotNullParameter(avatarList, "avatarList");
        this.data.clear();
        if (userZplanAvatarUrl != null) {
            this.data.add(userZplanAvatarUrl);
            z16 = true;
        } else {
            z16 = false;
        }
        this.containsUserZplanAvatar = z16;
        this.data.addAll(avatarList);
        notifyDataSetChanged();
    }

    public final void s0(d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void t0(int i3) {
        this.random = i3;
    }

    public final int m0() {
        return ViewUtils.dip2px(166.0f);
    }
}
