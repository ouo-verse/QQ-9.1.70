package tencent.im.oidb.cmd0x69f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x69f$RspBody extends MessageMicro<oidb_cmd0x69f$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_cmd0x69f$ChannelInfo> rpt_channel_list = PBField.initRepeatMessage(oidb_cmd0x69f$ChannelInfo.class);
    public final PBRepeatField<Integer> rpt_uint32_my_channel_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<oidb_cmd0x69f$ChannelInfo> rpt_recomm_channel_list = PBField.initRepeatMessage(oidb_cmd0x69f$ChannelInfo.class);
    public final PBRepeatField<ByteStringMicro> bytes_search_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_req_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_seq = PBField.initUInt32(0);
    public final PBBytesField bytes_refresh_backgroud_url = PBField.initBytes(ByteStringMicro.EMPTY);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 96, 106, 114, 176, 192, 210}, new String[]{"uint64_uin", "rpt_channel_list", "rpt_uint32_my_channel_id_list", "rpt_recomm_channel_list", "bytes_search_word", "uint32_req_channel_id", "uint32_channel_seq", "bytes_refresh_backgroud_url"}, new Object[]{0L, null, 0, null, byteStringMicro, 0, 0, byteStringMicro}, oidb_cmd0x69f$RspBody.class);
    }
}
