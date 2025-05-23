package ur1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ur1.a;
import vp1.af;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0015\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lur1/a;", "Landroidx/recyclerview/widget/ListAdapter;", "Lur1/e;", "Lur1/a$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "Lur1/d;", "cb", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lur1/d;", "callback", "<init>", "()V", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends ListAdapter<GuildCreateMemberData, b> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lur1/a$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lur1/e;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ur1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C11365a extends DiffUtil.ItemCallback<GuildCreateMemberData> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull GuildCreateMemberData oldItem, @NotNull GuildCreateMemberData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull GuildCreateMemberData oldItem, @NotNull GuildCreateMemberData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getAvatarId(), newItem.getAvatarId());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lur1/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lur1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lur1/d;", "callback", "", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lvp1/af;", UserInfo.SEX_FEMALE, "Lvp1/af;", "getBinding", "()Lvp1/af;", "binding", "<init>", "(Lur1/a;Landroid/content/Context;Lvp1/af;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final af binding;
        final /* synthetic */ a G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull a aVar, @NotNull Context context, af binding) {
            super(binding.getMRv());
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.G = aVar;
            this.context = context;
            this.binding = binding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(GuildCreateMemberData item, d dVar, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(item, "$item");
            if (!QQGuildUIUtil.v()) {
                int userType = item.getUserType();
                if (userType != 3) {
                    if (userType == 4 && dVar != null) {
                        dVar.b();
                    }
                } else if (dVar != null) {
                    dVar.a(item);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean p(b this$0, View view, MotionEvent motionEvent) {
            GuildCreateMemberData guildCreateMemberData;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object tag = view.getTag();
            if (tag instanceof GuildCreateMemberData) {
                guildCreateMemberData = (GuildCreateMemberData) tag;
            } else {
                guildCreateMemberData = null;
            }
            if (guildCreateMemberData != null) {
                if (guildCreateMemberData.getUserType() == 3 || guildCreateMemberData.getUserType() == 4) {
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action == 1 || action == 3) {
                            this$0.binding.getMRv().setAlpha(1.0f);
                            return false;
                        }
                        return false;
                    }
                    this$0.binding.getMRv().setAlpha(0.5f);
                    return false;
                }
                return false;
            }
            return false;
        }

        public final void n(@NotNull final GuildCreateMemberData item, @Nullable final d callback) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (callback != null) {
                LinearLayout mRv = this.binding.getMRv();
                Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
                callback.c(mRv, item);
            }
            int userType = item.getUserType();
            if (userType != 1) {
                if (userType != 3) {
                    if (userType != 4) {
                        this.binding.f442186e.setText(item.getUserName());
                        this.binding.f442185d.w(1, item.getAvatarId());
                        this.binding.f442185d.setVisibility(0);
                        this.binding.f442183b.setVisibility(8);
                        this.binding.f442184c.setVisibility(8);
                        this.binding.f442183b.setAlpha(1.0f);
                        this.binding.f442186e.setAlpha(1.0f);
                    } else {
                        this.binding.f442183b.setOperationIconType(item.getUserType());
                        this.binding.f442186e.setText(item.getUserName());
                        this.binding.f442183b.setVisibility(0);
                        this.binding.f442185d.setVisibility(8);
                        this.binding.f442184c.setVisibility(8);
                        this.binding.f442183b.setAlpha(1.0f);
                        this.binding.f442186e.setAlpha(1.0f);
                    }
                } else {
                    this.binding.f442183b.setOperationIconType(item.getUserType());
                    this.binding.f442186e.setText(item.getUserName());
                    this.binding.f442183b.setVisibility(0);
                    this.binding.f442185d.setVisibility(8);
                    this.binding.f442184c.setVisibility(8);
                    if (item.getEnable()) {
                        this.binding.f442183b.setAlpha(1.0f);
                        this.binding.f442186e.setAlpha(1.0f);
                    } else {
                        this.binding.f442183b.setAlpha(0.3f);
                        this.binding.f442186e.setAlpha(0.3f);
                    }
                }
            } else {
                this.binding.f442186e.setText(item.getUserName());
                this.binding.f442184c.setAvatarTinyId(item.getGuildId(), item.getAvatarId());
                this.binding.f442184c.setVisibility(0);
                this.binding.f442183b.setVisibility(8);
                this.binding.f442185d.setVisibility(8);
                this.binding.f442183b.setAlpha(1.0f);
                this.binding.f442186e.setAlpha(1.0f);
            }
            this.binding.getMRv().setOnClickListener(new View.OnClickListener() { // from class: ur1.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.o(GuildCreateMemberData.this, callback, view);
                }
            });
            this.binding.getMRv().setOnTouchListener(new View.OnTouchListener() { // from class: ur1.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean p16;
                    p16 = a.b.p(a.b.this, view, motionEvent);
                    return p16;
                }
            });
        }
    }

    public a() {
        super(new C11365a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        GuildCreateMemberData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "item");
        holder.n(item, this.callback);
        holder.itemView.setTag(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        af g16 = af.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new b(this, context, g16);
    }

    public final void k0(@NotNull d cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.callback = cb5;
    }
}
