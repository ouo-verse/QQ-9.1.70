package tencent.im.oidb.cmd0x74f;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x74f$RspBody extends MessageMicro<oidb_cmd0x74f$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_ret_code", DownloaderConstant.KEY_RANGE, "uint64_next_pull_time", "bool_display_entrance"}, new Object[]{0, null, 0L, Boolean.FALSE}, oidb_cmd0x74f$RspBody.class);
    public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0x74f$Range> range = PBField.initRepeatMessage(oidb_cmd0x74f$Range.class);
    public final PBUInt64Field uint64_next_pull_time = PBField.initUInt64(0);
    public final PBBoolField bool_display_entrance = PBField.initBool(false);
}
