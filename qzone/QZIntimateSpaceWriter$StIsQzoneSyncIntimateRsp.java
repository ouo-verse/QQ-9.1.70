package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.soload.biz.SoLoadIPCModule;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp extends MessageMicro<QZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{SoLoadIPCModule.KEY_IS_SYNC, "msg"}, new Object[]{Boolean.FALSE, ""}, QZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp.class);
    public final PBBoolField is_sync = PBField.initBool(false);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f430332msg = PBField.initString("");
}
