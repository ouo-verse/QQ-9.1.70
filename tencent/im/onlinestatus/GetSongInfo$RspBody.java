package tencent.im.onlinestatus;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetSongInfo$RspBody extends MessageMicro<GetSongInfo$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBBytesField err_msg;
    public final PBBytesField singer_name;
    public final PBBytesField song_name;

    static {
        String[] strArr = {CheckForwardServlet.KEY_ERR_CODE, "err_msg", "song_name", "singer_name"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro}, GetSongInfo$RspBody.class);
    }

    public GetSongInfo$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.err_msg = PBField.initBytes(byteStringMicro);
        this.song_name = PBField.initBytes(byteStringMicro);
        this.singer_name = PBField.initBytes(byteStringMicro);
    }
}
