package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$ClientModISpaceInfoRsp extends MessageMicro<QZIntimateProfileReader$ClientModISpaceInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"relation_days"}, new Object[]{0}, QZIntimateProfileReader$ClientModISpaceInfoRsp.class);
    public final PBUInt32Field relation_days = PBField.initUInt32(0);
}
