package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$RspSongExtendedInfo extends MessageMicro<aio_media$RspSongExtendedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_result", "rpt_msg_song_list"}, new Object[]{null, null}, aio_media$RspSongExtendedInfo.class);
    public aio_media$ResultInfo msg_result = new aio_media$ResultInfo();
    public final PBRepeatMessageField<aio_media$Song> rpt_msg_song_list = PBField.initRepeatMessage(aio_media$Song.class);
}
