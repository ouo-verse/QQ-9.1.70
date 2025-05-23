package zs2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u00a8\u0006\u0014"}, d2 = {"Lzs2/b;", "Lcom/tencent/qqnt/base/mvi/b;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", h.F, "Lzs2/b$a;", "Lzs2/b$b;", "Lzs2/b$c;", "Lzs2/b$d;", "Lzs2/b$e;", "Lzs2/b$f;", "Lzs2/b$g;", "Lzs2/b$h;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class b implements com.tencent.qqnt.base.mvi.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lzs2/b$a;", "Lzs2/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "b", "()Z", "isChecked", "normalMemberDel", "<init>", "(ZZ)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.b$a, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class DeleteTroopInfo extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isChecked;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean normalMemberDel;

        /* renamed from: a, reason: from getter */
        public final boolean getNormalMemberDel() {
            return this.normalMemberDel;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isChecked;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            boolean z17 = this.normalMemberDel;
            return i3 + (z17 ? 1 : z17 ? 1 : 0);
        }

        public String toString() {
            return "DeleteTroopInfo(isChecked=" + this.isChecked + ", normalMemberDel=" + this.normalMemberDel + ")";
        }

        public DeleteTroopInfo(boolean z16, boolean z17) {
            super(null);
            this.isChecked = z16;
            this.normalMemberDel = z17;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeleteTroopInfo)) {
                return false;
            }
            DeleteTroopInfo deleteTroopInfo = (DeleteTroopInfo) other;
            return this.isChecked == deleteTroopInfo.isChecked && this.normalMemberDel == deleteTroopInfo.normalMemberDel;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lzs2/b$b;", "Lzs2/b;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11713b extends b {

        /* renamed from: a, reason: collision with root package name */
        public static final C11713b f453140a = new C11713b();

        C11713b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lzs2/b$c;", "Lzs2/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "sUin", "b", "sMemberUin", "", "J", "()J", "lSecond", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.b$c, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class SetGagTroopMember extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String sUin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String sMemberUin;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long lSecond;

        /* renamed from: a, reason: from getter */
        public final long getLSecond() {
            return this.lSecond;
        }

        /* renamed from: b, reason: from getter */
        public final String getSMemberUin() {
            return this.sMemberUin;
        }

        /* renamed from: c, reason: from getter */
        public final String getSUin() {
            return this.sUin;
        }

        public int hashCode() {
            String str = this.sUin;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.sMemberUin;
            return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + com.tencent.mobileqq.guild.report.impl.b.a(this.lSecond);
        }

        public String toString() {
            return "SetGagTroopMember(sUin=" + this.sUin + ", sMemberUin=" + this.sMemberUin + ", lSecond=" + this.lSecond + ")";
        }

        public SetGagTroopMember(String str, String str2, long j3) {
            super(null);
            this.sUin = str;
            this.sMemberUin = str2;
            this.lSecond = j3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetGagTroopMember)) {
                return false;
            }
            SetGagTroopMember setGagTroopMember = (SetGagTroopMember) other;
            return Intrinsics.areEqual(this.sUin, setGagTroopMember.sUin) && Intrinsics.areEqual(this.sMemberUin, setGagTroopMember.sMemberUin) && this.lSecond == setGagTroopMember.lSecond;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzs2/b$d;", "Lzs2/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "keySwitch", "<init>", "(Z)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.b$d, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class UpdateDoNotDisturb extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean keySwitch;

        /* renamed from: a, reason: from getter */
        public final boolean getKeySwitch() {
            return this.keySwitch;
        }

        public int hashCode() {
            boolean z16 = this.keySwitch;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "UpdateDoNotDisturb(keySwitch=" + this.keySwitch + ")";
        }

        public UpdateDoNotDisturb(boolean z16) {
            super(null);
            this.keySwitch = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UpdateDoNotDisturb) && this.keySwitch == ((UpdateDoNotDisturb) other).keySwitch;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lzs2/b$h;", "Lzs2/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "b", "()J", "troopUin", "memberUin", "c", "I", "()I", "type", "<init>", "(JJI)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.b$h, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class UpdateMsgTip extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long troopUin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long memberUin;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: a, reason: from getter */
        public final long getMemberUin() {
            return this.memberUin;
        }

        /* renamed from: b, reason: from getter */
        public final long getTroopUin() {
            return this.troopUin;
        }

        /* renamed from: c, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return (((com.tencent.mobileqq.guild.report.impl.b.a(this.troopUin) * 31) + com.tencent.mobileqq.guild.report.impl.b.a(this.memberUin)) * 31) + this.type;
        }

        public String toString() {
            return "UpdateMsgTip(troopUin=" + this.troopUin + ", memberUin=" + this.memberUin + ", type=" + this.type + ")";
        }

        public UpdateMsgTip(long j3, long j16, int i3) {
            super(null);
            this.troopUin = j3;
            this.memberUin = j16;
            this.type = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateMsgTip)) {
                return false;
            }
            UpdateMsgTip updateMsgTip = (UpdateMsgTip) other;
            return this.troopUin == updateMsgTip.troopUin && this.memberUin == updateMsgTip.memberUin && this.type == updateMsgTip.type;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzs2/b$e;", "Lzs2/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "remark", "<init>", "(Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.b$e, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class UpdateFriendRemarkByRemark extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String remark;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateFriendRemarkByRemark(String remark) {
            super(null);
            Intrinsics.checkNotNullParameter(remark, "remark");
            this.remark = remark;
        }

        /* renamed from: a, reason: from getter */
        public final String getRemark() {
            return this.remark;
        }

        public int hashCode() {
            return this.remark.hashCode();
        }

        public String toString() {
            return "UpdateFriendRemarkByRemark(remark=" + this.remark + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UpdateFriendRemarkByRemark) && Intrinsics.areEqual(this.remark, ((UpdateFriendRemarkByRemark) other).remark);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lzs2/b$f;", "Lzs2/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "groupName", "I", "()I", "groupId", "<init>", "(Ljava/lang/String;I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.b$f, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class UpdateGroup extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String groupName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int groupId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateGroup(String groupName, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(groupName, "groupName");
            this.groupName = groupName;
            this.groupId = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getGroupId() {
            return this.groupId;
        }

        /* renamed from: b, reason: from getter */
        public final String getGroupName() {
            return this.groupName;
        }

        public int hashCode() {
            return (this.groupName.hashCode() * 31) + this.groupId;
        }

        public String toString() {
            return "UpdateGroup(groupName=" + this.groupName + ", groupId=" + this.groupId + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateGroup)) {
                return false;
            }
            UpdateGroup updateGroup = (UpdateGroup) other;
            return Intrinsics.areEqual(this.groupName, updateGroup.groupName) && this.groupId == updateGroup.groupId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzs2/b$g;", "Lzs2/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "colorCard", "<init>", "(Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.b$g, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class UpdateMemberCard extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String colorCard;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateMemberCard(String colorCard) {
            super(null);
            Intrinsics.checkNotNullParameter(colorCard, "colorCard");
            this.colorCard = colorCard;
        }

        /* renamed from: a, reason: from getter */
        public final String getColorCard() {
            return this.colorCard;
        }

        public int hashCode() {
            return this.colorCard.hashCode();
        }

        public String toString() {
            return "UpdateMemberCard(colorCard=" + this.colorCard + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UpdateMemberCard) && Intrinsics.areEqual(this.colorCard, ((UpdateMemberCard) other).colorCard);
        }
    }
}
