package trpc.qq_av.av_appsvr;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupInvite$GroupInviteMsgBody extends MessageMicro<GroupInvite$GroupInviteMsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field account;
    public final PBUInt32Field client_seq;
    public final PBUInt32Field flag;
    public final PBBytesField key;
    public final PBBytesField relation_buffer;
    public final PBUInt64Field relation_id;
    public final PBUInt32Field relation_type;
    public final PBBytesField reserve_buffer;
    public final PBUInt32Field room_id;
    public final PBUInt32Field send_time;
    public final PBUInt32Field video_msg_type;
    public final PBRepeatField<Long> to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);

    static {
        String[] strArr = {"to_uin", ShortVideoConstants.FROM_UIN, "key", AudienceReportConst.ROOM_ID, "client_seq", "flag", "relation_type", "relation_buffer", "account", "send_time", "reserve_buffer", "relation_id", "video_msg_type"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 66, 72, 80, 90, 96, 104}, strArr, new Object[]{0L, 0L, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0, 0, byteStringMicro, 0L, 0}, GroupInvite$GroupInviteMsgBody.class);
    }

    public GroupInvite$GroupInviteMsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key = PBField.initBytes(byteStringMicro);
        this.room_id = PBField.initUInt32(0);
        this.client_seq = PBField.initUInt32(0);
        this.flag = PBField.initUInt32(0);
        this.relation_type = PBField.initUInt32(0);
        this.relation_buffer = PBField.initBytes(byteStringMicro);
        this.account = PBField.initUInt32(0);
        this.send_time = PBField.initUInt32(0);
        this.reserve_buffer = PBField.initBytes(byteStringMicro);
        this.relation_id = PBField.initUInt64(0L);
        this.video_msg_type = PBField.initUInt32(0);
    }
}
