package tencent.im.oidb.cmd0xe9b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe9b$RspBody extends MessageMicro<oidb_0xe9b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"uint64_next_req_interval", "msg_basic_profile", "rpt_msg_label", "msg_qzone_info", "rpt_msg_selected_pic", "rpt_bytes_longnick", "rpt_msg_quests"}, new Object[]{0L, null, null, null, null, ByteStringMicro.EMPTY, null}, oidb_0xe9b$RspBody.class);
    public final PBUInt64Field uint64_next_req_interval = PBField.initUInt64(0);
    public oidb_0xe9b$BasicProfileData msg_basic_profile = new MessageMicro<oidb_0xe9b$BasicProfileData>() { // from class: tencent.im.oidb.cmd0xe9b.oidb_0xe9b$BasicProfileData
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_addfrd_src;
        public final PBBytesField bytes_place;
        public final PBUInt32Field uint32_comm_frd_num;
        public final PBUInt32Field uint32_age = PBField.initUInt32(0);
        public final PBUInt32Field uint32_gender = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"uint32_age", "uint32_gender", "bytes_place", "bytes_addfrd_src", "uint32_comm_frd_num"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, 0}, oidb_0xe9b$BasicProfileData.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_place = PBField.initBytes(byteStringMicro);
            this.bytes_addfrd_src = PBField.initBytes(byteStringMicro);
            this.uint32_comm_frd_num = PBField.initUInt32(0);
        }
    };
    public final PBRepeatMessageField<oidb_0xe9b$LabelInfo> rpt_msg_label = PBField.initRepeatMessage(oidb_0xe9b$LabelInfo.class);
    public oidb_0xe9b$QZoneInfo msg_qzone_info = new MessageMicro<oidb_0xe9b$QZoneInfo>() { // from class: tencent.im.oidb.cmd0xe9b.oidb_0xe9b$QZoneInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_space_name;
        public final PBBytesField bytes_update_content;
        public final PBRepeatField<String> str_newly_img_url;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_space_name", "bytes_update_content", "str_newly_img_url"}, new Object[]{byteStringMicro, byteStringMicro, ""}, oidb_0xe9b$QZoneInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_space_name = PBField.initBytes(byteStringMicro);
            this.bytes_update_content = PBField.initBytes(byteStringMicro);
            this.str_newly_img_url = PBField.initRepeat(PBStringField.__repeatHelper__);
        }
    };
    public final PBRepeatMessageField<oidb_0xe9b$SelectedPicInfo> rpt_msg_selected_pic = PBField.initRepeatMessage(oidb_0xe9b$SelectedPicInfo.class);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_longnick = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_0xe9b$Quest> rpt_msg_quests = PBField.initRepeatMessage(oidb_0xe9b$Quest.class);
}
