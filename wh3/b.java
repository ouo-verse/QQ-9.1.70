package wh3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.friend.FriendInfo;
import com.tencent.mobileqq.zplan.friend.Gender;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002DEB\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\bA\u0010BJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u0011\u001a\u00020\b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fH\u0007J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,RA\u00107\u001a!\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u0010?\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00068\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010:\u00a8\u0006F"}, d2 = {"Lwh3/b;", "Lcom/tencent/mobileqq/zplan/friend/b;", "Lwh3/b$a;", "holder", "Lcom/tencent/mobileqq/zplan/friend/c;", "data", "", "position", "", "n0", "", "isSelected", "u0", "", "friendInfos", "", "genderRequestList", "t0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "o0", "getItemCount", "Lcom/tencent/mobileqq/zplan/friend/e;", "D", "Lcom/tencent/mobileqq/zplan/friend/e;", "getFriendItemBinder", "()Lcom/tencent/mobileqq/zplan/friend/e;", "friendItemBinder", "", "E", "Ljava/util/Map;", "getDataList", "()Ljava/util/Map;", "setDataList", "(Ljava/util/Map;)V", "dataList", "Ljava/util/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "getGenderRequestList", "()Ljava/util/ArrayList;", "setGenderRequestList", "(Ljava/util/ArrayList;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", com.tencent.luggage.wxa.c8.c.G, "G", "Lkotlin/jvm/functions/Function1;", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "s0", "(Lkotlin/jvm/functions/Function1;)V", "itemClickListener", "value", "H", "I", "getCurSelectItem", "()I", "r0", "(I)V", "curSelectItem", "lastSelectItem", "<init>", "(Lcom/tencent/mobileqq/zplan/friend/e;)V", "J", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends com.tencent.mobileqq.zplan.friend.b<a> {

    /* renamed from: D, reason: from kotlin metadata */
    private final com.tencent.mobileqq.zplan.friend.e friendItemBinder;

    /* renamed from: E, reason: from kotlin metadata */
    private Map<Integer, FriendInfo> dataList;

    /* renamed from: F, reason: from kotlin metadata */
    private ArrayList<Integer> genderRequestList;

    /* renamed from: G, reason: from kotlin metadata */
    private Function1<? super Integer, Unit> itemClickListener;

    /* renamed from: H, reason: from kotlin metadata */
    private int curSelectItem;

    /* renamed from: I, reason: from kotlin metadata */
    private int lastSelectItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lwh3/b$a;", "Lcom/tencent/mobileqq/zplan/friend/a;", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "avatar", "H", "p", "selectBg", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "selectLine", "J", "o", "genderImage", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a extends com.tencent.mobileqq.zplan.friend.a {

        /* renamed from: G, reason: from kotlin metadata */
        private final ImageView avatar;

        /* renamed from: H, reason: from kotlin metadata */
        private final ImageView selectBg;

        /* renamed from: I, reason: from kotlin metadata */
        private final ImageView selectLine;

        /* renamed from: J, reason: from kotlin metadata */
        private final ImageView genderImage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.r6b);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.zplan_iv_icon)");
            this.avatar = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.r6c);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.zplan_iv_icon_bg)");
            this.selectBg = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.r6j);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.zplan_iv_select_line)");
            this.selectLine = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.r6a);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.zplan_iv_gender)");
            this.genderImage = (ImageView) findViewById4;
        }

        @Override // com.tencent.mobileqq.zplan.friend.a
        /* renamed from: l, reason: from getter */
        public ImageView getAvatar() {
            return this.avatar;
        }

        /* renamed from: o, reason: from getter */
        public final ImageView getGenderImage() {
            return this.genderImage;
        }

        /* renamed from: p, reason: from getter */
        public final ImageView getSelectBg() {
            return this.selectBg;
        }

        /* renamed from: q, reason: from getter */
        public final ImageView getSelectLine() {
            return this.selectLine;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.tencent.mobileqq.zplan.friend.e friendItemBinder) {
        super(friendItemBinder);
        Intrinsics.checkNotNullParameter(friendItemBinder, "friendItemBinder");
        this.friendItemBinder = friendItemBinder;
        this.dataList = new HashMap();
        this.genderRequestList = new ArrayList<>();
        this.curSelectItem = -1;
        this.lastSelectItem = -1;
    }

    private final void n0(a holder, FriendInfo data, int position) {
        int i3;
        Integer num = this.genderRequestList.get(position);
        Intrinsics.checkNotNullExpressionValue(num, "genderRequestList[position]");
        int intValue = num.intValue();
        if (intValue == Gender.FEMALE.getGender()) {
            i3 = R.drawable.ifo;
        } else {
            i3 = intValue == Gender.MALE.getGender() ? R.drawable.igs : R.drawable.igx;
        }
        if (data != null) {
            this.friendItemBinder.c(data, holder);
        } else {
            holder.getAvatar().setImageDrawable(q.b(R.drawable.if7));
        }
        holder.getGenderImage().setImageResource(i3);
        QLog.i("ZplanChooseRoleAdapter", 4, "bind View Item " + (data != null ? data.getName() : null) + " ");
        u0(this.curSelectItem == position, holder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(b this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super Integer, Unit> function1 = this$0.itemClickListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.zplan.friend.b, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        n0(holder, this.dataList.get(Integer.valueOf(position)), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: wh3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.p0(b.this, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dhf, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new a(itemView);
    }

    public final void r0(int i3) {
        this.curSelectItem = i3;
        notifyItemChanged(i3);
        int i16 = this.lastSelectItem;
        if (i16 != i3 && i16 >= 0) {
            notifyItemChanged(i16);
        }
        QLog.i("ZplanChooseRoleAdapter", 4, "curSelect Item  " + this.curSelectItem);
        this.lastSelectItem = i3;
    }

    public final void s0(Function1<? super Integer, Unit> function1) {
        this.itemClickListener = function1;
    }

    public final void t0(Map<Integer, FriendInfo> friendInfos, List<Integer> genderRequestList) {
        QLog.i("ZplanChooseRoleAdapter", 4, "update Data " + friendInfos);
        if (genderRequestList != null) {
            this.genderRequestList.clear();
            this.genderRequestList.addAll(genderRequestList);
        }
        if (this.dataList.isEmpty()) {
            if (friendInfos != null) {
                this.dataList.putAll(friendInfos);
            }
            QLog.i("ZplanChooseRoleAdapter", 4, "list " + this.dataList);
            notifyDataSetChanged();
            return;
        }
        int size = this.dataList.size();
        int i3 = this.curSelectItem;
        boolean z16 = false;
        if (i3 >= 0 && i3 < size) {
            z16 = true;
        }
        if (z16) {
            this.dataList.put(Integer.valueOf(i3), friendInfos != null ? friendInfos.get(Integer.valueOf(this.curSelectItem)) : null);
            notifyItemChanged(this.curSelectItem);
        }
    }

    private final void u0(boolean isSelected, a holder) {
        int i3 = isSelected ? 0 : 4;
        holder.getSelectBg().setVisibility(i3);
        holder.getSelectLine().setVisibility(i3);
    }
}
