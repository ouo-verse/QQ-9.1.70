package x15;

import com.tencent.icgame.trpc.yes.common.TcloudServerOuterClass$GetUserTCloudSignReq;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ox0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lx15/a;", "Lox0/a;", "", "b", "<init>", "()V", "d", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class a extends ox0.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0006"}, d2 = {"Lx15/a$a;", "", "Lmqq/app/NewIntent;", "a", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: x15.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final NewIntent a() {
            return a.C10966a.a(new MessageMicro<TcloudServerOuterClass$GetUserTCloudSignReq>() { // from class: com.tencent.icgame.trpc.yes.common.TcloudServerOuterClass$GetUserTCloudSignReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uid", "scene", "client_version", "platform", "user_id"}, new Object[]{0L, 0, "", 0, 0L}, TcloudServerOuterClass$GetUserTCloudSignReq.class);
                public final PBUInt64Field uid = PBField.initUInt64(0);
                public final PBInt32Field scene = PBField.initInt32(0);
                public final PBStringField client_version = PBField.initString("");
                public final PBInt32Field platform = PBField.initInt32(0);
                public final PBUInt64Field user_id = PBField.initUInt64(0);
            }, a.class);
        }

        Companion() {
        }
    }

    @Override // ox0.a
    protected int b() {
        return 201;
    }
}
