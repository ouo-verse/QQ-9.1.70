package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StorageNTSdkExtInfo$PhotoEchoMsgInfo extends MessageMicro<StorageNTSdkExtInfo$PhotoEchoMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"client_req_info", "oidb_head", "privacy", "handset", "origin_modify_time"}, new Object[]{null, ByteStringMicro.EMPTY, 0, 0, 0}, StorageNTSdkExtInfo$PhotoEchoMsgInfo.class);
    public StorageNTSdkExtInfo$PhotoApplyUploadReqExtInfo client_req_info = new StorageNTSdkExtInfo$PhotoApplyUploadReqExtInfo();
    public final PBBytesField oidb_head = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field privacy = PBField.initUInt32(0);
    public final PBUInt32Field handset = PBField.initUInt32(0);
    public final PBUInt32Field origin_modify_time = PBField.initUInt32(0);
}
