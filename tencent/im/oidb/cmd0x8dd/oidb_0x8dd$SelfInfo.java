package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$SelfInfo extends MessageMicro<oidb_0x8dd$SelfInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_birthday;
    public final PBBytesField bytes_nick;
    public oidb_0x8dd$LoginScore msg_cur_login_score;
    public final PBStringField str_third_line_icon;
    public final PBStringField str_third_line_info;
    public final PBUInt32Field uint32_all_task_num;
    public final PBUInt32Field uint32_charm;
    public final PBUInt32Field uint32_charm_level;
    public final PBUInt32Field uint32_finish_task_num;
    public final PBUInt32Field uint32_god_flag;
    public final PBUInt32Field uint32_heart_num;
    public final PBUInt32Field uint32_real_video_flag;
    public final PBUInt32Field uint32_vote_increment;
    public final PBUInt32Field uint32_vote_num;
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56, 64, 72, 80, 90, 98, 104, 112, 122, 128, 136}, new String[]{"uint64_tinyid", "uint32_gender", "uint32_age", "bytes_birthday", "bytes_nick", "uint32_vote_num", "uint32_vote_increment", "uint32_charm", "uint32_charm_level", "uint32_god_flag", "str_third_line_info", "str_third_line_icon", "uint32_heart_num", "uint32_real_video_flag", "msg_cur_login_score", "uint32_finish_task_num", "uint32_all_task_num"}, new Object[]{0L, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, "", "", 0, 0, null, 0, 0}, oidb_0x8dd$SelfInfo.class);
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [tencent.im.oidb.cmd0x8dd.oidb_0x8dd$LoginScore] */
    public oidb_0x8dd$SelfInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_birthday = PBField.initBytes(byteStringMicro);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_vote_num = PBField.initUInt32(0);
        this.uint32_vote_increment = PBField.initUInt32(0);
        this.uint32_charm = PBField.initUInt32(0);
        this.uint32_charm_level = PBField.initUInt32(0);
        this.uint32_god_flag = PBField.initUInt32(0);
        this.str_third_line_info = PBField.initString("");
        this.str_third_line_icon = PBField.initString("");
        this.uint32_heart_num = PBField.initUInt32(0);
        this.uint32_real_video_flag = PBField.initUInt32(0);
        this.msg_cur_login_score = new MessageMicro<oidb_0x8dd$LoginScore>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$LoginScore
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_login_day", "uint32_login_score"}, new Object[]{0, 0}, oidb_0x8dd$LoginScore.class);
            public final PBUInt32Field uint32_login_day = PBField.initUInt32(0);
            public final PBUInt32Field uint32_login_score = PBField.initUInt32(0);
        };
        this.uint32_finish_task_num = PBField.initUInt32(0);
        this.uint32_all_task_num = PBField.initUInt32(0);
    }
}
