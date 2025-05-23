package tencent.im.oidb.cmd0xf90;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf90$ReqBody extends MessageMicro<oidb_0xf90$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"group_code", "seq", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "appid"}, new Object[]{0L, 0L, 0L, 0L}, oidb_0xf90$ReqBody.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBUInt64Field random = PBField.initUInt64(0);
    public final PBUInt64Field appid = PBField.initUInt64(0);
}
