package s34;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Ls34/c;", "", "<init>", "()V", "a", "b", "c", "d", "Ls34/c$a;", "Ls34/c$b;", "Ls34/c$c;", "Ls34/c$d;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Ls34/c$a;", "Ls34/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "isAdded", "()Z", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s34.c$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class RobotAddedStatePayload extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isAdded;

        public RobotAddedStatePayload(boolean z16) {
            super(null);
            this.isAdded = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RobotAddedStatePayload) && this.isAdded == ((RobotAddedStatePayload) other).isAdded) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isAdded;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "RobotAddedStatePayload(isAdded=" + this.isAdded + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ls34/c$b;", "Ls34/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getRobotAvatar", "()Ljava/lang/String;", "robotAvatar", "<init>", "(Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s34.c$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class RobotAvatarPayload extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String robotAvatar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RobotAvatarPayload(@NotNull String robotAvatar) {
            super(null);
            Intrinsics.checkNotNullParameter(robotAvatar, "robotAvatar");
            this.robotAvatar = robotAvatar;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RobotAvatarPayload) && Intrinsics.areEqual(this.robotAvatar, ((RobotAvatarPayload) other).robotAvatar)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.robotAvatar.hashCode();
        }

        @NotNull
        public String toString() {
            return "RobotAvatarPayload(robotAvatar=" + this.robotAvatar + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ls34/c$c;", "Ls34/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getRobotDesc", "()Ljava/lang/String;", "robotDesc", "<init>", "(Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s34.c$c, reason: collision with other inner class name and from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class RobotDescPayload extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String robotDesc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RobotDescPayload(@NotNull String robotDesc) {
            super(null);
            Intrinsics.checkNotNullParameter(robotDesc, "robotDesc");
            this.robotDesc = robotDesc;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RobotDescPayload) && Intrinsics.areEqual(this.robotDesc, ((RobotDescPayload) other).robotDesc)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.robotDesc.hashCode();
        }

        @NotNull
        public String toString() {
            return "RobotDescPayload(robotDesc=" + this.robotDesc + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ls34/c$d;", "Ls34/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getRobotName", "()Ljava/lang/String;", "robotName", "<init>", "(Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s34.c$d, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class RobotNamePayload extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String robotName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RobotNamePayload(@NotNull String robotName) {
            super(null);
            Intrinsics.checkNotNullParameter(robotName, "robotName");
            this.robotName = robotName;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RobotNamePayload) && Intrinsics.areEqual(this.robotName, ((RobotNamePayload) other).robotName)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.robotName.hashCode();
        }

        @NotNull
        public String toString() {
            return "RobotNamePayload(robotName=" + this.robotName + ")";
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}
