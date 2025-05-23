package tencent.im.groupvideo.memposinfo;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class memposinfo$AccountExtInfo extends MessageMicro<memposinfo$AccountExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_common_info", "msg_mini_program_info"}, new Object[]{null, null}, memposinfo$AccountExtInfo.class);
    public memposinfo$CommonInfo msg_common_info = new memposinfo$CommonInfo();
    public memposinfo$MiniProgramInfo msg_mini_program_info = new MessageMicro<memposinfo$MiniProgramInfo>() { // from class: tencent.im.groupvideo.memposinfo.memposinfo$MiniProgramInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], memposinfo$MiniProgramInfo.class);
    };
}
