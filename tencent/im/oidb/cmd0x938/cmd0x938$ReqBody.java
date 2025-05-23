package tencent.im.oidb.cmd0x938;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x938$ReqBody extends MessageMicro<cmd0x938$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"msg_comm_param", "msg_client_param", "msg_datacard_param", "msg_operation_param", "msg_scorelist_param", "msg_floatbutton_param"}, new Object[]{null, null, null, null, null, null}, cmd0x938$ReqBody.class);
    public cmd0x938$CommParamReq msg_comm_param = new MessageMicro<cmd0x938$CommParamReq>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$CommParamReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_version", "uint32_platform"}, new Object[]{ByteStringMicro.EMPTY, 0}, cmd0x938$CommParamReq.class);
        public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
    };
    public cmd0x938$ClientParam msg_client_param = new MessageMicro<cmd0x938$ClientParam>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$ClientParam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x938$ClientParam.class);
    };
    public cmd0x938$DataCardParam msg_datacard_param = new MessageMicro<cmd0x938$DataCardParam>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$DataCardParam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "uint32_gender"}, new Object[]{0L, 0}, cmd0x938$DataCardParam.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    };
    public cmd0x938$OperationParam msg_operation_param = new MessageMicro<cmd0x938$OperationParam>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$OperationParam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x938$OperationParam.class);
    };
    public cmd0x938$ScoreListParam msg_scorelist_param = new MessageMicro<cmd0x938$ScoreListParam>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$ScoreListParam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x938$ScoreListParam.class);
    };
    public cmd0x938$FloatButtonParam msg_floatbutton_param = new MessageMicro<cmd0x938$FloatButtonParam>() { // from class: tencent.im.oidb.cmd0x938.cmd0x938$FloatButtonParam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x938$FloatButtonParam.class);
    };
}
