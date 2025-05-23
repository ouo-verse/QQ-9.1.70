package tencent.im.oidb.cmd0xf8e;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf8e$InfoValue extends MessageMicro<oidb_0xf8e$InfoValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 72, 82, 88, 96}, new String[]{"group_code", "seq", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "uin", "nickname", "title", "jump_url", "icon_url", AlbumCacheData.CREATE_TIME, "app_name", "appid", QQHealthReportApiImpl.MSG_TYPE_KEY}, new Object[]{0L, 0L, 0, 0L, "", "", "", "", 0, "", 0L, 0}, oidb_0xf8e$InfoValue.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBUInt32Field random = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBStringField app_name = PBField.initString("");
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBEnumField msg_type = PBField.initEnum(0);
}
