package zs2;

import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.state.data.SquareJSConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u00a8\u0006\u001c"}, d2 = {"Lzs2/a;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", h.F, "i", "j", "k", "l", "Lzs2/a$a;", "Lzs2/a$b;", "Lzs2/a$c;", "Lzs2/a$d;", "Lzs2/a$e;", "Lzs2/a$f;", "Lzs2/a$g;", "Lzs2/a$h;", "Lzs2/a$i;", "Lzs2/a$j;", "Lzs2/a$k;", "Lzs2/a$l;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzs2/a$b;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "keySwitch", "<init>", "(Z)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$b, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class DoNotDisturbUpdate extends a {

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
            return "DoNotDisturbUpdate(keySwitch=" + this.keySwitch + ")";
        }

        public DoNotDisturbUpdate(boolean z16) {
            super(null);
            this.keySwitch = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DoNotDisturbUpdate) && this.keySwitch == ((DoNotDisturbUpdate) other).keySwitch;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzs2/a$f;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "gagMsg", "<init>", "(Z)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$f, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class GagMsgSettingUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean gagMsg;

        /* renamed from: a, reason: from getter */
        public final boolean getGagMsg() {
            return this.gagMsg;
        }

        public int hashCode() {
            boolean z16 = this.gagMsg;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "GagMsgSettingUpdate(gagMsg=" + this.gagMsg + ")";
        }

        public GagMsgSettingUpdate(boolean z16) {
            super(null);
            this.gagMsg = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GagMsgSettingUpdate) && this.gagMsg == ((GagMsgSettingUpdate) other).gagMsg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lzs2/a$g;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "b", "()Z", "isSuccess", "I", "()I", "errorCode", "<init>", "(ZI)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$g, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class MsgTipUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int errorCode;

        /* renamed from: a, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.errorCode;
        }

        public String toString() {
            return "MsgTipUpdate(isSuccess=" + this.isSuccess + ", errorCode=" + this.errorCode + ")";
        }

        public MsgTipUpdate(boolean z16, int i3) {
            super(null);
            this.isSuccess = z16;
            this.errorCode = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MsgTipUpdate)) {
                return false;
            }
            MsgTipUpdate msgTipUpdate = (MsgTipUpdate) other;
            return this.isSuccess == msgTipUpdate.isSuccess && this.errorCode == msgTipUpdate.errorCode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzs2/a$i;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "isSpecialCare", "<init>", "(Z)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$i, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class SpecialCareUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSpecialCare;

        /* renamed from: a, reason: from getter */
        public final boolean getIsSpecialCare() {
            return this.isSpecialCare;
        }

        public int hashCode() {
            boolean z16 = this.isSpecialCare;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "SpecialCareUpdate(isSpecialCare=" + this.isSpecialCare + ")";
        }

        public SpecialCareUpdate(boolean z16) {
            super(null);
            this.isSpecialCare = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SpecialCareUpdate) && this.isSpecialCare == ((SpecialCareUpdate) other).isSpecialCare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzs2/a$j;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "errorCode", "<init>", "(I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$j, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class TroopAdminUpdateFail extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int errorCode;

        /* renamed from: a, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        public int hashCode() {
            return this.errorCode;
        }

        public String toString() {
            return "TroopAdminUpdateFail(errorCode=" + this.errorCode + ")";
        }

        public TroopAdminUpdateFail(int i3) {
            super(null);
            this.errorCode = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TroopAdminUpdateFail) && this.errorCode == ((TroopAdminUpdateFail) other).errorCode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lzs2/a$k;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "B", "()B", QCircleDaTongConstant.ElementParamValue.OPERATION, "<init>", "(B)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$k, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class TroopAdminUpdateSuccess extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final byte operation;

        /* renamed from: a, reason: from getter */
        public final byte getOperation() {
            return this.operation;
        }

        public int hashCode() {
            return this.operation;
        }

        public String toString() {
            return "TroopAdminUpdateSuccess(operation=" + ((int) this.operation) + ")";
        }

        public TroopAdminUpdateSuccess(byte b16) {
            super(null);
            this.operation = b16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TroopAdminUpdateSuccess) && this.operation == ((TroopAdminUpdateSuccess) other).operation;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R'\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lzs2/a$a;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "c", "()Z", "isSuccess", "b", "I", "()I", "errorCode", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "<init>", "(ZILjava/util/ArrayList;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class DeleteTroopMemberUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int errorCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final ArrayList<String> uinList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeleteTroopMemberUpdate(boolean z16, int i3, ArrayList<String> uinList) {
            super(null);
            Intrinsics.checkNotNullParameter(uinList, "uinList");
            this.isSuccess = z16;
            this.errorCode = i3;
            this.uinList = uinList;
        }

        /* renamed from: a, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        public final ArrayList<String> b() {
            return this.uinList;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.errorCode) * 31) + this.uinList.hashCode();
        }

        public String toString() {
            return "DeleteTroopMemberUpdate(isSuccess=" + this.isSuccess + ", errorCode=" + this.errorCode + ", uinList=" + this.uinList + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeleteTroopMemberUpdate)) {
                return false;
            }
            DeleteTroopMemberUpdate deleteTroopMemberUpdate = (DeleteTroopMemberUpdate) other;
            return this.isSuccess == deleteTroopMemberUpdate.isSuccess && this.errorCode == deleteTroopMemberUpdate.errorCode && Intrinsics.areEqual(this.uinList, deleteTroopMemberUpdate.uinList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lzs2/a$c;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getMStrGroup", "()Ljava/lang/String;", "mStrGroup", "b", "I", "getGroupId", "()I", "groupId", "<init>", "(Ljava/lang/String;I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$c, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class FriendGroupUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String mStrGroup;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int groupId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FriendGroupUpdate(String mStrGroup, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(mStrGroup, "mStrGroup");
            this.mStrGroup = mStrGroup;
            this.groupId = i3;
        }

        public int hashCode() {
            return (this.mStrGroup.hashCode() * 31) + this.groupId;
        }

        public String toString() {
            return "FriendGroupUpdate(mStrGroup=" + this.mStrGroup + ", groupId=" + this.groupId + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FriendGroupUpdate)) {
                return false;
            }
            FriendGroupUpdate friendGroupUpdate = (FriendGroupUpdate) other;
            return Intrinsics.areEqual(this.mStrGroup, friendGroupUpdate.mStrGroup) && this.groupId == friendGroupUpdate.groupId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzs2/a$d;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "remark", "<init>", "(Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$d, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class FriendRemarkNameByRemarkUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String remark;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FriendRemarkNameByRemarkUpdate(String remark) {
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
            return "FriendRemarkNameByRemarkUpdate(remark=" + this.remark + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FriendRemarkNameByRemarkUpdate) && Intrinsics.areEqual(this.remark, ((FriendRemarkNameByRemarkUpdate) other).remark);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lzs2/a$e;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/businessCard/data/BusinessCard;", "a", "Lcom/tencent/mobileqq/businessCard/data/BusinessCard;", "()Lcom/tencent/mobileqq/businessCard/data/BusinessCard;", IndividuationUrlHelper.UrlId.CARD_HOME, "<init>", "(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$e, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class FriendRemarkNameUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final BusinessCard card;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FriendRemarkNameUpdate(BusinessCard card) {
            super(null);
            Intrinsics.checkNotNullParameter(card, "card");
            this.card = card;
        }

        /* renamed from: a, reason: from getter */
        public final BusinessCard getCard() {
            return this.card;
        }

        public int hashCode() {
            return this.card.hashCode();
        }

        public String toString() {
            return "FriendRemarkNameUpdate(card=" + this.card + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FriendRemarkNameUpdate) && Intrinsics.areEqual(this.card, ((FriendRemarkNameUpdate) other).card);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lzs2/a$h;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "b", "()Z", "isSuccess", "isCancelShield", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$h, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class ShieldMsgUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isCancelShield;

        /* renamed from: a, reason: from getter */
        public final boolean getIsCancelShield() {
            return this.isCancelShield;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            boolean z17 = this.isCancelShield;
            return i3 + (z17 ? 1 : z17 ? 1 : 0);
        }

        public String toString() {
            return "ShieldMsgUpdate(isSuccess=" + this.isSuccess + ", isCancelShield=" + this.isCancelShield + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShieldMsgUpdate)) {
                return false;
            }
            ShieldMsgUpdate shieldMsgUpdate = (ShieldMsgUpdate) other;
            return this.isSuccess == shieldMsgUpdate.isSuccess && this.isCancelShield == shieldMsgUpdate.isCancelShield;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzs2/a$l;", "Lzs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "memberName", "<init>", "(Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zs2.a$l, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class TroopMemberNameUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String memberName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TroopMemberNameUpdate(String memberName) {
            super(null);
            Intrinsics.checkNotNullParameter(memberName, "memberName");
            this.memberName = memberName;
        }

        /* renamed from: a, reason: from getter */
        public final String getMemberName() {
            return this.memberName;
        }

        public int hashCode() {
            return this.memberName.hashCode();
        }

        public String toString() {
            return "TroopMemberNameUpdate(memberName=" + this.memberName + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TroopMemberNameUpdate) && Intrinsics.areEqual(this.memberName, ((TroopMemberNameUpdate) other).memberName);
        }
    }
}
