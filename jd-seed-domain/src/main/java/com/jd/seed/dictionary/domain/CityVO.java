package com.jd.seed.dictionary.domain;

import java.util.Date;

import com.jd.seed.base.domain.BaseVO;
import com.jd.seed.base.domain.Entity;
import com.jd.seed.dictionary.Dictionary;
import com.jd.seed.dictionary.city.City;

/**
 * <pre>
 * 城市
 * 
 * </pre>
 * 
 * @author mecarlen 2017年11月21日 下午5:00:14
 */
public class CityVO extends BaseVO<Long, CityEntity> implements City, Dictionary, Entity<Long> {
	// 中文名
	private String zhName;
	// 英文名
	private String enName;
	// 三字码
	private String unityCode;
	// 中文名全拼
	private String zhFullPin;
	// 中文名简拼
	private String zhShortPin;
	// 优先级
	private Integer priority;

	private CityVO() {
	}

	private CityVO(Builder builder) {
		this.id = builder.id;
		this.zhName = builder.zhName;
		this.enName = builder.enName;
		this.unityCode = builder.unityCode;
		this.zhFullPin = builder.zhFullPin;
		this.zhShortPin = builder.zhShortPin;
		this.priority = builder.priority;
		this.state = builder.state;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
	}

	// setter
	private void setZhName(String zhName) {
		this.zhName = zhName;
	}

	private void setEnName(String enName) {
		this.enName = enName;
	}

	private void setUnityCode(String unityCode) {
		this.unityCode = unityCode;
	}

	private void setZhFullPin(String zhFullPin) {
		this.zhFullPin = zhFullPin;
	}

	private void setZhShortPin(String zhShortPin) {
		this.zhShortPin = zhShortPin;
	}

	private void setPriority(int priority) {
		this.priority = priority;
	}

	public static class Builder {
		// id
		private Long id;
		// 中文名
		final private String zhName;
		// 英文名
		private String enName;
		// 三字码
		final private String unityCode;
		// 中文名全拼
		private String zhFullPin;
		// 中文名简拼
		private String zhShortPin;
		// 优先级
		private int priority = -1;
		// 状态
		private Entity.State state = Entity.State.NORMAL;
		// 创建时间
		private Date createTime;
		// 更新时间
		private Date updateTime;

		public Builder(final String zhName, final String unityCode) {
			this.zhName = zhName;
			this.unityCode = unityCode;
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder enName(final String enName) {
			this.enName = enName;
			return this;
		}

		public Builder zhFullPin(final String zhFullPin) {
			this.zhFullPin = zhFullPin;
			return this;
		}

		public Builder zhShortPin(final String zhShortPin) {
			this.zhShortPin = zhShortPin;
			return this;
		}

		public Builder priority(final int priority) {
			this.priority = priority;
			return this;
		}

		public Builder state(final Entity.State state) {
			if (null != state) {
				this.state = state;
			}
			return this;
		}

		public Builder createTime(final Date createTime) {
			if (null != createTime) {
				this.createTime = new Date(createTime.getTime());
			}
			return this;
		}

		public Builder updateTime(final Date updateTime) {
			if (null != updateTime) {
				this.updateTime = new Date(updateTime.getTime());
			}
			return this;
		}

		public CityVO build() {
			if (null == createTime) {
				this.createTime = new Date();
			}
			return new CityVO(this);
		}
	}

	// getter
	public String getZhName() {
		return zhName;
	}

	public String getEnName() {
		return enName;
	}

	public String getUnityCode() {
		return unityCode;
	}

	public String getZhFullPin() {
		return zhFullPin;
	}

	public String getZhShortPin() {
		return zhShortPin;
	}

	public Integer getPriority() {
		return priority;
	}

	@Override
	public CityVO id(Long id) {
		this.setId(id);
		return this;
	}

	public CityVO zhName(final String zhName) {
		this.setZhName(zhName);
		return this;
	}

	public CityVO enName(final String enName) {
		this.setEnName(enName);
		return this;
	}

	public CityVO zhFullPin(final String zhFullPin) {
		this.setZhFullPin(zhFullPin);
		return this;
	}

	public CityVO zhShortPin(final String zhShortPin) {
		this.setZhShortPin(zhShortPin);
		return this;
	}

	public CityVO unityCode(final String unityCode) {
		this.setUnityCode(unityCode);
		return this;
	}

	public CityVO priority(final int priority) {
		this.setPriority(priority);
		return this;
	}

	@Override
	public CityVO state(final Entity.State state) {
		if (null != state) {
			this.setState(state);
		}
		return this;
	}

	@Override
	public CityVO createTime(final Date createTime) {
		if (null != createTime) {
			this.setCreateTime(new Date(createTime.getTime()));
		}
		return this;
	}

	@Override
	public CityVO updateTime(Date updateTime) {
		if (null != updateTime) {
			this.setUpdateTime(new Date(updateTime.getTime()));
		}
		return this;
	}

	@Override
	public CityEntity toEntity() {
		return CityEntity.getInstance(this);
	}

	final public static CityVO getInstance(final City city) {
		if (null == city)
			return null;
		return new CityVO.Builder(city.getZhName(), city.getUnityCode())
				.state(Entity.State.getInstance(city.getState())).zhFullPin(city.getZhFullPin())
				.zhShortPin(city.getZhShortPin()).enName(city.getEnName()).priority(city.getPriority())
				.createTime(city.getCreateTime()).updateTime(city.getUpdateTime()).id(city.getId()).build();
	}

	@Override
	public String getName() {
		return getZhName();
	}
}
