package tencent.im.oidb.cmd0xe61;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe61$BeancurdCubeInfo extends MessageMicro<oidb_0xe61$BeancurdCubeInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_busi_data_req;
    public final PBBytesField bytes_busi_data_rsp;
    public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_event_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_pull_interval_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_last_pull_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_valid_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_flag = PBField.initUInt64(0);

    static {
        String[] strArr = {MessageForUniteGrayTip.KEY_UINT64_BUSI_ID, "uint64_uin", "uint64_frd_uin", "uint64_event_time", "uint64_pull_interval_time", "uint64_last_pull_time", "uint64_valid_time", "uint64_flag", "bytes_busi_data_req", "bytes_busi_data_rsp"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 8002, 8010}, strArr, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, byteStringMicro, byteStringMicro}, oidb_0xe61$BeancurdCubeInfo.class);
    }

    public oidb_0xe61$BeancurdCubeInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_busi_data_req = PBField.initBytes(byteStringMicro);
        this.bytes_busi_data_rsp = PBField.initBytes(byteStringMicro);
    }
}
