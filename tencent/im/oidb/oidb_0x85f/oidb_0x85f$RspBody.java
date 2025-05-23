package tencent.im.oidb.oidb_0x85f;

import com.tencent.luggage.wxa.uf.n;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x85f$RspBody extends MessageMicro<oidb_0x85f$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, n.CTRL_INDEX}, new String[]{"msg_comm_param", "msg_read_score", "msg_read_list", "msg_match_check", "msg_gray_open"}, new Object[]{null, null, null, null, null}, oidb_0x85f$RspBody.class);
    public oidb_0x85f$CommParamRsp msg_comm_param = new MessageMicro<oidb_0x85f$CommParamRsp>() { // from class: tencent.im.oidb.oidb_0x85f.oidb_0x85f$CommParamRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x85f$CommParamRsp.class);
    };
    public oidb_0x85f$ReadFaceScoreBatchRsp msg_read_score = new MessageMicro<oidb_0x85f$ReadFaceScoreBatchRsp>() { // from class: tencent.im.oidb.oidb_0x85f.oidb_0x85f$ReadFaceScoreBatchRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_rsp_list"}, new Object[]{null}, oidb_0x85f$ReadFaceScoreBatchRsp.class);
        public final PBRepeatMessageField<oidb_0x85f$ReadFaceScoreRsp> msg_rsp_list = PBField.initRepeatMessage(oidb_0x85f$ReadFaceScoreRsp.class);
    };
    public oidb_0x85f$ReadScoreListRsp msg_read_list = new MessageMicro<oidb_0x85f$ReadScoreListRsp>() { // from class: tencent.im.oidb.oidb_0x85f.oidb_0x85f$ReadScoreListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_rsp_list", "uint32_index_end"}, new Object[]{null, 0}, oidb_0x85f$ReadScoreListRsp.class);
        public final PBRepeatMessageField<oidb_0x85f$ReadFaceScoreRsp> msg_rsp_list = PBField.initRepeatMessage(oidb_0x85f$ReadFaceScoreRsp.class);
        public final PBUInt32Field uint32_index_end = PBField.initUInt32(0);
    };
    public oidb_0x85f$MatchCheckRsp msg_match_check = new MessageMicro<oidb_0x85f$MatchCheckRsp>() { // from class: tencent.im.oidb.oidb_0x85f.oidb_0x85f$MatchCheckRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_match_item"}, new Object[]{null}, oidb_0x85f$MatchCheckRsp.class);
        public final PBRepeatMessageField<oidb_0x85f$MatchItem> msg_match_item = PBField.initRepeatMessage(oidb_0x85f$MatchItem.class);
    };
    public oidb_0x85f$GrayOpenRsp msg_gray_open = new MessageMicro<oidb_0x85f$GrayOpenRsp>() { // from class: tencent.im.oidb.oidb_0x85f.oidb_0x85f$GrayOpenRsp
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_info_card_entry_guest_url;
        public final PBBytesField bytes_info_card_entry_host_url;
        public final PBBytesField bytes_nearby_entry_url;
        public final PBBytesField bytes_nearby_entry_wording;
        public final PBUInt32Field uint32_show_card = PBField.initUInt32(0);
        public final PBUInt32Field uint32_show_list = PBField.initUInt32(0);
        public final PBUInt64Field uint64_next_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_nearby_entry_color = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66}, new String[]{"uint32_show_card", "uint32_show_list", "uint64_next_time", "uint32_nearby_entry_color", "bytes_nearby_entry_wording", "bytes_info_card_entry_host_url", "bytes_info_card_entry_guest_url", "bytes_nearby_entry_url"}, new Object[]{0, 0, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0x85f$GrayOpenRsp.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_nearby_entry_wording = PBField.initBytes(byteStringMicro);
            this.bytes_info_card_entry_host_url = PBField.initBytes(byteStringMicro);
            this.bytes_info_card_entry_guest_url = PBField.initBytes(byteStringMicro);
            this.bytes_nearby_entry_url = PBField.initBytes(byteStringMicro);
        }
    };
}
