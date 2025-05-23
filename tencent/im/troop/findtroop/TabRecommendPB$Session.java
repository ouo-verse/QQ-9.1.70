package tencent.im.troop.findtroop;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class TabRecommendPB$Session extends MessageMicro<TabRecommendPB$Session> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField group_session_info;
    public final PBBytesField guild_session_info;
    public TabRecommendPB$PersionParam persion_param_info;
    public final PBBytesField person_session_info;
    public final PBBytesField qevent_session_info;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"group_session_info", "guild_session_info", "person_session_info", "qevent_session_info", "persion_param_info"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, null}, TabRecommendPB$Session.class);
    }

    public TabRecommendPB$Session() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.group_session_info = PBField.initBytes(byteStringMicro);
        this.guild_session_info = PBField.initBytes(byteStringMicro);
        this.person_session_info = PBField.initBytes(byteStringMicro);
        this.qevent_session_info = PBField.initBytes(byteStringMicro);
        this.persion_param_info = new TabRecommendPB$PersionParam();
    }
}
