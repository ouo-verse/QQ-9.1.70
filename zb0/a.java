package zb0;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lzb0/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "Lcom/tencent/biz/qqcircle/comment/at/bean/QFSCommentAtEntity;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "L1", "O1", "", "i", "Ljava/util/List;", "N1", "()Ljava/util/List;", "selectedList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "selectStatusLivaData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QFSCommentAtEntity> selectedList = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<QFSCommentAtEntity>> selectStatusLivaData = new MutableLiveData<>();

    public final void L1(@NotNull QFSCommentAtEntity item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.selectedList.contains(item)) {
            return;
        }
        this.selectedList.add(item);
        this.selectStatusLivaData.postValue(UIStateData.obtainInsert(0).setData(false, item));
    }

    @NotNull
    public final MutableLiveData<UIStateData<QFSCommentAtEntity>> M1() {
        return this.selectStatusLivaData;
    }

    @NotNull
    public final List<QFSCommentAtEntity> N1() {
        return this.selectedList;
    }

    public final void O1(@NotNull QFSCommentAtEntity item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (!this.selectedList.contains(item)) {
            return;
        }
        this.selectedList.remove(item);
        this.selectStatusLivaData.postValue(UIStateData.obtainDelete().setData(false, item));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QFSShareSelectMemberViewModel";
    }
}
