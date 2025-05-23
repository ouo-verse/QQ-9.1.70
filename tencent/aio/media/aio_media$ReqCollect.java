package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$ReqCollect extends MessageMicro<aio_media$ReqCollect> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_song_id"}, new Object[]{""}, aio_media$ReqCollect.class);
    public final PBStringField str_song_id = PBField.initString("");
}
