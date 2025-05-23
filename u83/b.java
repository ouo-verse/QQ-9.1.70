package u83;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.newalbum.collector.m;
import com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugBaseModel;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b!\u0010\"J\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\r\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\u0005J\u001c\u0010\u000e\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tJ\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lu83/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lu83/b$a;", "Landroid/view/ViewGroup;", "p0", "", "p1", "k0", "", "Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugBaseModel;", "photos", QCircleDaTongConstant.ElementParamValue.OPERATION, "", "l0", "j0", "Landroid/widget/TextView;", "textTitle", "data", "m0", "getItemCount", "Lu83/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lu83/k;", "listener", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getResults", "()Ljava/util/List;", "setResults", "(Ljava/util/List;)V", ForwardMiniChooseFriendOption.RESULT_LIST, "D", "I", "<init>", "(Lu83/k;)V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<WinkNewAlbumDebugBaseModel> results;

    /* renamed from: D, reason: from kotlin metadata */
    private int operation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010#\u001a\u00020\u0004\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010\"\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019\u00a8\u0006&"}, d2 = {"Lu83/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "p0", "", NodeProps.ON_LONG_CLICK, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setItemImage", "(Landroid/widget/ImageView;)V", "itemImage", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "G", "o", "setTextTitle", "textTitle", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setTextBeauty", "textBeauty", "itemView", "<init>", "(Lu83/b;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class a extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private ImageView itemImage;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView textView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView textTitle;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private TextView textBeauty;
        final /* synthetic */ b I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.I = bVar;
            View findViewById = itemView.findViewById(R.id.y4u);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_image)");
            this.itemImage = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.md_);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_label)");
            this.textView = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.kbs);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_title)");
            this.textTitle = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f10626689);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_beauty)");
            this.textBeauty = (TextView) findViewById4;
            this.itemImage.setOnClickListener(this);
            this.itemImage.setOnLongClickListener(this);
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getItemImage() {
            return this.itemImage;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getTextBeauty() {
            return this.textBeauty;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getTextTitle() {
            return this.textTitle;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            this.I.listener.onItemClick(getAdapterPosition());
            EventCollector.getInstance().onViewClicked(v3);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(@Nullable View p06) {
            EventCollector.getInstance().onViewLongClickedBefore(p06);
            this.I.listener.onItemLongClick(getAdapterPosition());
            EventCollector.getInstance().onViewLongClicked(p06);
            return true;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    public b(@NotNull k listener) {
        List<WinkNewAlbumDebugBaseModel> emptyList;
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.results = emptyList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.results.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a p06, int p16) {
        float score;
        StringBuilder sb5;
        String str;
        Intrinsics.checkNotNullParameter(p06, "p0");
        WinkNewAlbumDebugBaseModel winkNewAlbumDebugBaseModel = this.results.get(p16);
        String photoPath = winkNewAlbumDebugBaseModel.getPhotoPath();
        if (winkNewAlbumDebugBaseModel.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            p06.getItemImage().setImageBitmap(f11.c.n(photoPath, 224));
        } else {
            Option obtain = Option.obtain();
            obtain.setTargetView(p06.getItemImage());
            obtain.setUrl(photoPath);
            obtain.setRequestWidth(obtain.getRequestWidth());
            obtain.setRequestHeight(obtain.getRequestHeight());
            QQPicLoader.f201806a.d().loadImage(obtain, null);
        }
        if (this.operation == 2) {
            score = winkNewAlbumDebugBaseModel.getPhotoSimilarity();
            sb5 = new StringBuilder();
            str = "\u56fe\u7247\u76f8\u4f3c\u5ea6\uff1a";
        } else {
            score = winkNewAlbumDebugBaseModel.getScore();
            sb5 = new StringBuilder();
            str = "\u6587\u5b57\u76f8\u4f3c\u5ea6\uff1a";
        }
        sb5.append(str);
        sb5.append(score);
        p06.getTextView().setText(sb5.toString());
        m0(p06.getTextTitle(), winkNewAlbumDebugBaseModel);
        m mVar = m.f324110a;
        if (mVar.g().get(winkNewAlbumDebugBaseModel.getPhotoID()) != null) {
            p06.getTextBeauty().setText("\u7f8e\u89c2\u5ea6\uff1a" + mVar.g().get(winkNewAlbumDebugBaseModel.getPhotoID()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup p06, int p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Context context = p06.getContext();
        if (context == null) {
            context = null;
        }
        View itemView = LayoutInflater.from(context).inflate(R.layout.f167979ea2, p06, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new a(this, itemView);
    }

    public final void l0(@NotNull List<WinkNewAlbumDebugBaseModel> photos, int operation) {
        Intrinsics.checkNotNullParameter(photos, "photos");
        this.results = photos;
        this.operation = operation;
        notifyDataSetChanged();
    }

    public final void m0(@NotNull TextView textTitle, @NotNull WinkNewAlbumDebugBaseModel data) {
        Intrinsics.checkNotNullParameter(textTitle, "textTitle");
        Intrinsics.checkNotNullParameter(data, "data");
        int argb = Color.argb(191, 128, 128, 128);
        int i3 = this.operation;
        String str = "";
        int i16 = -1;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (data.getIsTextShift()) {
                            str = "\u672a\u5165\u5e93";
                            i16 = -65536;
                        } else {
                            str = "\u5165\u5e93";
                            i16 = -16711936;
                        }
                    }
                } else if (data.getPhotoSimilarity() < w83.b.f445025a.w()) {
                    str = "\u4e0d\u76f8\u4f3c";
                    i16 = -16711936;
                } else if (Intrinsics.areEqual(data.getPhotoID(), this.results.get(0).getPhotoID())) {
                    str = "\u57fa\u51c6\u56fe\u7247";
                    i16 = -16776961;
                } else {
                    str = "\u76f8\u4f3c";
                    i16 = -65536;
                }
            } else if (data.getIsShown()) {
                str = "\u66dd\u5149";
                i16 = -16711936;
            } else {
                str = "\u672a\u66dd\u5149";
                i16 = -256;
            }
        } else {
            argb = 0;
        }
        textTitle.setText(str);
        textTitle.setTextColor(i16);
        textTitle.setBackgroundColor(argb);
    }
}
