package q84;

import android.view.KeyEvent;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import jb4.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010$\u001a\u00020 \u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016R\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010)R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lq84/d;", "Lq84/c;", "", "f", "Lq84/b;", "selectInfo", "", "reSelected", "e", "Lq84/a;", "baseScroller", "b", "scrollStatus", "a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "c", "d", h.F, "feedSelectInfo", "w", UserInfo.SEX_FEMALE, "H", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "l", ExifInterface.LATITUDE_SOUTH, "", "position", "", "positionOffset", "positionOffsetPixels", "g", "Ljb4/p;", "Ljb4/p;", "getFeedIoc", "()Ljb4/p;", "feedIoc", "Ljava/util/HashSet;", "Ljava/util/HashSet;", "mHolderSet", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "mScrollerList", "mCommonScrollerList", "i", "Lq84/b;", "<init>", "(Ljb4/p;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final p feedIoc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private HashSet<RecyclerView.ViewHolder> mHolderSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ArrayList<a> mScrollerList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<c> mCommonScrollerList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b feedSelectInfo;

    public d(p feedIoc) {
        Intrinsics.checkNotNullParameter(feedIoc, "feedIoc");
        this.feedIoc = feedIoc;
        this.mHolderSet = new HashSet<>();
        this.mScrollerList = new ArrayList<>();
        this.mCommonScrollerList = new ArrayList<>();
    }

    private final void e(b selectInfo, boolean reSelected) {
        if (this.mHolderSet.size() == 0) {
            QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle notifyItemViewOnFeedSelected mHolderSet == null or mScrollerList == null");
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = this.mHolderSet.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder next = it.next();
            if (next.getAdapterPosition() == -1) {
                QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onFeedSelected , holder.position == -1  | selectInfo = " + selectInfo + " | holder = " + next);
            } else if (next.getAdapterPosition() == selectInfo.getMPosition()) {
                QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onFeedSelected , really dispatch  | selectInfo = " + selectInfo + " | holder = " + next);
                KeyEvent.Callback callback = next.itemView;
                if (callback instanceof c) {
                    Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.view.viewpager.IViewPagerScrollStatus");
                    ((c) callback).l(selectInfo);
                }
                Iterator<c> it5 = this.mCommonScrollerList.iterator();
                while (it5.hasNext()) {
                    it5.next().l(selectInfo);
                }
                Iterator<a> it6 = this.mScrollerList.iterator();
                while (it6.hasNext()) {
                    a next2 = it6.next();
                    if (reSelected) {
                        if (next2.a()) {
                            QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onFeedSelected second time, really dispatch | selectInfo = " + selectInfo + " | holder = " + next);
                            next2.e(selectInfo, next);
                        }
                    } else {
                        next2.e(selectInfo, next);
                    }
                }
            }
        }
    }

    private final void f() {
        Iterator<a> it = this.mScrollerList.iterator();
        while (it.hasNext()) {
            it.next().g(this.mHolderSet);
        }
    }

    @Override // q84.c
    public void F(b feedSelectInfo) {
        Intrinsics.checkNotNullParameter(feedSelectInfo, "feedSelectInfo");
        Iterator<RecyclerView.ViewHolder> it = this.mHolderSet.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder mHolderSet = it.next();
            Intrinsics.checkNotNullExpressionValue(mHolderSet, "mHolderSet");
            RecyclerView.ViewHolder viewHolder = mHolderSet;
            if (viewHolder.itemView instanceof c) {
                QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onPaused  | selectInfo = " + feedSelectInfo + " | holder = " + viewHolder);
                KeyEvent.Callback callback = viewHolder.itemView;
                Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.view.viewpager.IViewPagerScrollStatus");
                ((c) callback).F(feedSelectInfo);
            }
        }
        Iterator<a> it5 = this.mScrollerList.iterator();
        while (it5.hasNext()) {
            a mScrollerList = it5.next();
            Intrinsics.checkNotNullExpressionValue(mScrollerList, "mScrollerList");
            mScrollerList.c(feedSelectInfo);
        }
    }

    @Override // q84.c
    public void H(b feedSelectInfo) {
        Intrinsics.checkNotNullParameter(feedSelectInfo, "feedSelectInfo");
        Iterator<RecyclerView.ViewHolder> it = this.mHolderSet.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder mHolderSet = it.next();
            Intrinsics.checkNotNullExpressionValue(mHolderSet, "mHolderSet");
            RecyclerView.ViewHolder viewHolder = mHolderSet;
            if (viewHolder.itemView instanceof c) {
                QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onStop  | selectInfo = " + feedSelectInfo + " | holder = " + viewHolder);
                KeyEvent.Callback callback = viewHolder.itemView;
                Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.view.viewpager.IViewPagerScrollStatus");
                ((c) callback).H(feedSelectInfo);
            }
        }
        Iterator<a> it5 = this.mScrollerList.iterator();
        while (it5.hasNext()) {
            a mScrollerList = it5.next();
            Intrinsics.checkNotNullExpressionValue(mScrollerList, "mScrollerList");
            mScrollerList.f(feedSelectInfo);
        }
    }

    @Override // q84.c
    public void S(b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        Iterator<RecyclerView.ViewHolder> it = this.mHolderSet.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder mHolderSet = it.next();
            Intrinsics.checkNotNullExpressionValue(mHolderSet, "mHolderSet");
            RecyclerView.ViewHolder viewHolder = mHolderSet;
            if (viewHolder.getAdapterPosition() == selectInfo.getMPosition()) {
                QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onFeedUnSelected , really dispatch  | selectInfo = " + selectInfo + " | holder = " + viewHolder);
                KeyEvent.Callback callback = viewHolder.itemView;
                if (callback instanceof c) {
                    Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.view.viewpager.IViewPagerScrollStatus");
                    ((c) callback).S(selectInfo);
                }
            }
        }
    }

    @Override // q84.c
    public void l(b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        selectInfo.getMPosition();
        QLog.i("ViewPager2StatusManager", 2, "fs_lifecycle onFeedSelected  selectInfo = " + selectInfo);
        b bVar = this.feedSelectInfo;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            if (bVar.getMPosition() == selectInfo.getMPosition()) {
                QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onFeedSelected  repeat , not dispatch");
                return;
            }
        }
        this.feedSelectInfo = selectInfo;
        e(selectInfo, false);
    }

    @Override // q84.c
    public void onDestroy() {
        QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onDestroy");
        Iterator<RecyclerView.ViewHolder> it = this.mHolderSet.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder mHolderSet = it.next();
            Intrinsics.checkNotNullExpressionValue(mHolderSet, "mHolderSet");
            RecyclerView.ViewHolder viewHolder = mHolderSet;
            if (viewHolder.itemView instanceof c) {
                QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onDestroy  | holder = " + viewHolder);
                KeyEvent.Callback callback = viewHolder.itemView;
                Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.view.viewpager.IViewPagerScrollStatus");
                ((c) callback).onDestroy();
            }
        }
        Iterator<a> it5 = this.mScrollerList.iterator();
        while (it5.hasNext()) {
            a mScrollerList = it5.next();
            Intrinsics.checkNotNullExpressionValue(mScrollerList, "mScrollerList");
            mScrollerList.b();
        }
        this.mHolderSet.clear();
        this.mScrollerList.clear();
    }

    @Override // q84.c
    public void w(b feedSelectInfo) {
        Intrinsics.checkNotNullParameter(feedSelectInfo, "feedSelectInfo");
        Iterator<RecyclerView.ViewHolder> it = this.mHolderSet.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder mHolderSet = it.next();
            Intrinsics.checkNotNullExpressionValue(mHolderSet, "mHolderSet");
            RecyclerView.ViewHolder viewHolder = mHolderSet;
            if (viewHolder.itemView instanceof c) {
                if (viewHolder.getAdapterPosition() == -1) {
                    QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onResumed , holder.position == -1  | selectInfo = " + feedSelectInfo + " | holder = " + viewHolder);
                } else {
                    QLog.i("ViewPager2StatusManager", 1, "fs_lifecycle onResumed  | holder = " + viewHolder);
                    KeyEvent.Callback callback = viewHolder.itemView;
                    Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.view.viewpager.IViewPagerScrollStatus");
                    ((c) callback).w(feedSelectInfo);
                }
            }
        }
        Iterator<a> it5 = this.mScrollerList.iterator();
        while (it5.hasNext()) {
            a mScrollerList = it5.next();
            Intrinsics.checkNotNullExpressionValue(mScrollerList, "mScrollerList");
            mScrollerList.d(feedSelectInfo);
        }
    }

    public final void a(c scrollStatus) {
        if (scrollStatus == null) {
            return;
        }
        this.mCommonScrollerList.add(scrollStatus);
    }

    public final void b(a baseScroller) {
        if (baseScroller == null) {
            return;
        }
        this.mScrollerList.add(baseScroller);
    }

    public final void c(RecyclerView.ViewHolder holder) {
        if (holder == null) {
            return;
        }
        if (!this.mHolderSet.contains(holder)) {
            this.mHolderSet.add(holder);
            f();
        }
        KeyEvent.Callback callback = holder.itemView;
        if (callback instanceof IRFWLayerItemViewScrollerStatus) {
            Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus");
            ((IRFWLayerItemViewScrollerStatus) callback).onViewHolderAttachedToWindow(holder);
        }
        QLog.i("ViewPager2StatusManager", 2, "fs_lifecycle addViewHolder  holderNum = " + this.mHolderSet.size() + " | holder.getAdapterPosition() = " + holder.getAdapterPosition() + " | holder = " + holder);
    }

    public final void d(RecyclerView.ViewHolder holder) {
        if (holder == null) {
            return;
        }
        if (!this.mHolderSet.contains(holder)) {
            this.mHolderSet.add(holder);
            f();
        }
        QLog.i("ViewPager2StatusManager", 2, "fs_lifecycle bindViewHolder  holderNum = " + this.mHolderSet.size() + " | holder.getAdapterPosition() = " + holder.getAdapterPosition());
        if (this.feedIoc.getPosition() == holder.getAdapterPosition()) {
            QLog.i("ViewPager2StatusManager", 2, "fs_lifecycle addViewHolder  hit target , try faster dispatch");
            e(new b(holder.getAdapterPosition()), false);
        }
    }

    public final void h(RecyclerView.ViewHolder holder) {
        if (holder == null) {
            return;
        }
        if (this.mHolderSet.remove(holder)) {
            KeyEvent.Callback callback = holder.itemView;
            if (callback instanceof IRFWLayerItemViewScrollerStatus) {
                Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus");
                ((IRFWLayerItemViewScrollerStatus) callback).onViewHolderDetachedFromWindow(holder);
            }
        }
        QLog.i("ViewPager2StatusManager", 2, "fs_lifecycle removeViewHolder  holderNum = " + this.mHolderSet.size() + " | holder.getAdapterPosition() = " + holder.getAdapterPosition() + " | holder = " + holder);
    }

    public void g(int position, float positionOffset, int positionOffsetPixels) {
    }
}
